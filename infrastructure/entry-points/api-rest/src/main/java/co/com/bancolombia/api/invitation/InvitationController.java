package co.com.bancolombia.api.invitation;

import co.com.bancolombia.api.invitation.model.CreateInvitationRequest;
import co.com.bancolombia.api.invitation.model.AcceptInvitationRequest;
import co.com.bancolombia.api.invitation.model.InvitationMapper;
import co.com.bancolombia.api.invitation.model.InvitationRequest;
import co.com.bancolombia.api.invitation.model.InvitationResponse;
import co.com.bancolombia.model.invitations.Invitation;
import co.com.bancolombia.usecase.invitation.InvitationUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/invitations")
@RequiredArgsConstructor
public class InvitationController {

    private final InvitationUseCase invitationUseCase;

    @PostMapping("/get")
    public ResponseEntity<InvitationResponse> getInvitation(
            @RequestBody InvitationRequest request) {

        return invitationUseCase.getInvitationById(request.getId())
                .map(InvitationMapper::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<InvitationResponse> createInvitation(
            @RequestBody CreateInvitationRequest request) {

        Invitation invitation = new Invitation();
        invitation.setName_person(request.getPersonName());
        invitation.setNumber_cell(Long.parseLong(request.getPersonPhone()));

        Invitation created = invitationUseCase.createInvitation(invitation);

        return ResponseEntity
                .status(201)
                .body(InvitationMapper.toResponse(created));
    }

    @PostMapping("/accept")
    public ResponseEntity<InvitationResponse> acceptInvitation(
            @RequestBody AcceptInvitationRequest request) {

        Invitation invitation = invitationUseCase.acceptInvitation(
                UUID.fromString(request.getId())
        );

        return ResponseEntity.ok(InvitationMapper.toResponse(invitation));
    }
}
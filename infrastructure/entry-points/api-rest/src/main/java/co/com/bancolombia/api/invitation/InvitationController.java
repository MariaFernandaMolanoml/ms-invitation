package co.com.bancolombia.api.invitation;

import co.com.bancolombia.api.invitation.model.InvitationMapper;
import co.com.bancolombia.api.invitation.model.InvitationRequest;
import co.com.bancolombia.api.invitation.model.InvitationResponse;
import co.com.bancolombia.usecase.invitation.InvitationUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
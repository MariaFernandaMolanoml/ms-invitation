package co.com.bancolombia.api.invitation.model;

import co.com.bancolombia.api.gift.model.GiftResponse;
import co.com.bancolombia.model.invitations.Invitation;
import co.com.bancolombia.model.status.Status;

import java.util.Date;
import java.util.UUID;

public class InvitationMapper {

    public static InvitationResponse toResponse(Invitation invitation) {
        if (invitation == null) {
            return null;
        }

        InvitationResponse response = new InvitationResponse();
        response.setId(invitation.getId().toString());
        response.setStatus(invitation.getStatus());
        response.setGuestName(invitation.getName_person());

        if (invitation.getGift() != null) {
            GiftResponse giftResponse = new GiftResponse(
                    invitation.getGift().getId().toString(),
                    invitation.getGift().getName(),
                    invitation.getGift().getStatus().name()
            );
            response.setGift(giftResponse);
        }

        return response;
    }
    public static Invitation toDomain(CreateInvitationRequest request) {
        Invitation invitation = new Invitation();
        invitation.setName_person(request.getPersonName());
        invitation.setNumber_cell(Long.parseLong(request.getPersonPhone()));
        return invitation;
    }
}

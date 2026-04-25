package co.com.bancolombia.api.invitation.model;

import co.com.bancolombia.api.gift.model.GiftResponse;
import co.com.bancolombia.model.invitations.Invitation;

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
            GiftResponse giftResponse = new GiftResponse();
            giftResponse.setName(invitation.getGift().getName());
            response.setGift(giftResponse);
        }

        return response;
    }
}

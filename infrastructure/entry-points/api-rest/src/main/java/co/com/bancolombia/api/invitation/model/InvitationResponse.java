package co.com.bancolombia.api.invitation.model;

import co.com.bancolombia.api.gift.model.GiftResponse;
import co.com.bancolombia.model.status.Status;
import lombok.Data;

@Data
public class InvitationResponse {
    private String id;
    private Status status;
    private String guestName;
    private GiftResponse gift;
}
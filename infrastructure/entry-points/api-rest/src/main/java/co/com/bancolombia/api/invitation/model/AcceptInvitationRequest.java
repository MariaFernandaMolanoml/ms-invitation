package co.com.bancolombia.api.invitation.model;

import lombok.Data;

@Data
public class AcceptInvitationRequest {
    private String id;
    private String code;
}

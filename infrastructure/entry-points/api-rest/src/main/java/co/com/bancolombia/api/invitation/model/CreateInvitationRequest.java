package co.com.bancolombia.api.invitation.model;

import lombok.Data;

@Data
public class CreateInvitationRequest {
    private String personName;
    private String personPhone;
}
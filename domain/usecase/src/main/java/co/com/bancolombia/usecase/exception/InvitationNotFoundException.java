package co.com.bancolombia.usecase.exception;

public class InvitationNotFoundException extends RuntimeException {
    public InvitationNotFoundException() {
        super("Invitación no encontrada");
    }
}
package co.com.bancolombia.usecase.exception;

public class InvalidInvitationStateException extends RuntimeException {
    public InvalidInvitationStateException() {
        super("Estado inválido para aceptar invitación");
    }
}

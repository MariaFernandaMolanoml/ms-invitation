package co.com.bancolombia.usecase.exception;

public class NoAvailableGiftsException extends RuntimeException {
    public NoAvailableGiftsException() {
        super("No hay regalos disponibles");
    }
}
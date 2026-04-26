package co.com.bancolombia.api.exception;

import co.com.bancolombia.usecase.exception.NoAvailableGiftsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoAvailableGiftsException.class)
    public ResponseEntity<ErrorResponse> handleNoAvailableGifts(NoAvailableGiftsException ex) {
        ErrorResponse error = new ErrorResponse(
                "NO_AVAILABLE_GIFTS",
                ex.getMessage()
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
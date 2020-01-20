package microservices.msscbrewery.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handle(MethodArgumentNotValidException e) {
        return ResponseEntity.badRequest().body(e.getBindingResult().getFieldError().toString());
    }
}

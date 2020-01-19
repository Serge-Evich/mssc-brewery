package microservices.msscbrewery.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List<String>> handle(ConstraintViolationException e) {
        return ResponseEntity.badRequest().body(e.getConstraintViolations().stream()
                .map(violation -> violation.getPropertyPath() + ":" + violation.getMessage())
                .collect(Collectors.toList()));
    }
}

package com.test.cm2.Exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(ExceptionHandlers.RelatedEntityError.class)
    public ResponseEntity<String> handleRelatedEntityError(ExceptionHandlers.RelatedEntityError e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    //duplicate
    @ExceptionHandler(ExceptionHandlers.DuplicateError.class)
    public ResponseEntity<String> handleDuplicateError(ExceptionHandlers.RelatedEntityError e) {
    return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
}


}


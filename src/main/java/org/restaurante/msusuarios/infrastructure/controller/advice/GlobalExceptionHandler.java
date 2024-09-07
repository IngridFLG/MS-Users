package org.restaurante.msusuarios.infrastructure.controller.advice;
import org.restaurante.msusuarios.domain.exceptions.IsOlderUserException;
import org.restaurante.msusuarios.infrastructure.jpa.exception.ExistsEmailException;
import org.restaurante.msusuarios.infrastructure.jpa.exception.ExistsUserException;
import org.restaurante.msusuarios.infrastructure.jpa.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleException(Exception ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }

    @ExceptionHandler({IsOlderUserException.class})
    public ResponseEntity<Object> isOlderHandleException(IsOlderUserException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler({ExistsEmailException.class})
    public ResponseEntity<Object> existsEmailHandleException(ExistsEmailException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler({ExistsUserException.class})
    public ResponseEntity<Object> existsUserHandleException(ExistsUserException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler({UserNotFoundException.class})
    public ResponseEntity<Object> userNotFoundHandleException(UserNotFoundException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}

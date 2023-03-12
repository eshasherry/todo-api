package com.rest.webservice.todoapi.exception;

import com.rest.webservice.todoapi.entity.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorDetails> handleAllException(Exception ex){
        ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(), LocalDate.now());
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(TodoNotFoundException.class)
    public ResponseEntity<ErrorDetails> todoNotFoundException(Exception exception){
        ErrorDetails errorDetails = new ErrorDetails(exception.getMessage(), LocalDate.now());
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler({AuthenticationException.class})
    public ResponseEntity<ErrorDetails> unAuthorized(Exception exception){
        ErrorDetails errorDetails = new ErrorDetails("Authentication failed at controller advice", LocalDate.now());
        return new ResponseEntity<>(errorDetails, HttpStatus.UNAUTHORIZED);
    }
}

package com.microservice.UserService.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class ExpectionHandlerController extends ResponseEntityExceptionHandler {


// when ever  ResourceNotFoundException exception occur in whole project
// by   @ExceptionHandler(ResourceNotFoundException.class) anotation
// this method will called
@ExceptionHandler(ResourceNotFoundException.class)
protected ResponseEntity<String> handleResourcenotFoundException(ResourceNotFoundException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

    String message = ex.getMessage();
    return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);    }
}

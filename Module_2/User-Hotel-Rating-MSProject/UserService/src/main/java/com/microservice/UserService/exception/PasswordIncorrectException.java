package com.microservice.UserService.exception;

public class PasswordIncorrectException extends  RuntimeException {
    public PasswordIncorrectException() {
        super("Resource not Found");
    }
    public PasswordIncorrectException(String message) {
        super(message);
    }

}

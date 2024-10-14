package com.microservice.ApiGateway.exception;

public class CustomException  extends RuntimeException{
    public CustomException(String message){super(message);}
}
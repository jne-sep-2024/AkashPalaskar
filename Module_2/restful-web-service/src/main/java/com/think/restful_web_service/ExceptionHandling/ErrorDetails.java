package com.think.restful_web_service.ExceptionHandling;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ErrorDetails {
    private LocalDateTime timeStamp;
    private String message;
    private String details;

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }


    public String getMessage() {
        return message;
    }


    public String getDetails() {
        return details;
    }


    public ErrorDetails(LocalDateTime timeStamp, String message, String details) {
        this.timeStamp = timeStamp;
        this.message = message;
        this.details = details;
    }
}

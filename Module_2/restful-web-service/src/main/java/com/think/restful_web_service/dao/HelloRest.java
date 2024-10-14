package com.think.restful_web_service.dao;

public class HelloRest {
    private  String message;

    @Override
    public String toString() {
        return "HelloRest{" +
                "message='" + message + '\'' +
                '}';
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HelloRest(String message) {
        this.message = message;
    }
}

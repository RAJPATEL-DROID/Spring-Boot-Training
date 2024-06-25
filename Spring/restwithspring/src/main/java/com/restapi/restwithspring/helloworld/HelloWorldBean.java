package com.restapi.restwithspring.helloworld;

public class HelloWorldBean {
    private String message;

    public HelloWorldBean(String howAreYou) {
        this.message = howAreYou;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "HelloWorldBean{" +
                "message='" + message + '\'' +
                '}';
    }
}

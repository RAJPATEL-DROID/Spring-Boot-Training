package org.springdemo.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public  String  greetings(String name) {
        return "good morning, " + name;

    }
}
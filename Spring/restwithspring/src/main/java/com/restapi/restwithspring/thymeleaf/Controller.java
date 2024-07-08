package com.restapi.restwithspring.thymeleaf;

import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class Controller {

    @RequestMapping("/hello")
    public String sayHello() {
           return "hello";
    }

}
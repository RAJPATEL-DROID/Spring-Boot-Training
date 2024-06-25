package com.restapi.restwithspring.helloworld;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorlRest {

    @RequestMapping("/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    @RequestMapping("/hello-world-bean/{name}")
    public HelloWorldBean helloWorldBean(@PathVariable String name) {

        return new HelloWorldBean("How Are you " + name + " ?");

    }

}

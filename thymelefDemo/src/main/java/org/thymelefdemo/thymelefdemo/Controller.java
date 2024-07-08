package org.thymelefdemo.thymelefdemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Controller
public class Controller {

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/sendData")
    public ModelAndView getData() {

        ModelAndView modelAndView = new ModelAndView("data");

        modelAndView.addObject("message", "sendData to Templates");

        return modelAndView;
    }

    @RequestMapping("/users")
    public ModelAndView getUsers(){

        ModelAndView modelAndView = new ModelAndView("users");

        Users user = new Users();

        user.setFirstName("Raj");

        user.setLastName("Kumar");
        user.setScore(90);
        modelAndView.addObject("users",user );
        return modelAndView;
    }


}

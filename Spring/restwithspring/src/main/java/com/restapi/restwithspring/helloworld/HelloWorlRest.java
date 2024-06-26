package com.restapi.restwithspring.helloworld;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorlRest {

    private MessageSource messageSource;

    public HelloWorlRest(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @RequestMapping(path = "/hello-world", method = RequestMethod.GET)
    public String helloWorld() {
        return "Hello World";
    }

    @RequestMapping(value = "/hello-world-bean/{name}", method = RequestMethod.GET)
    public HelloWorldBean helloWorldBean(@PathVariable String name) {
        return new HelloWorldBean("How Are you " + name + " ?");

    }


    @RequestMapping(path = "/hello-world-internationalised", method = RequestMethod.GET)
    public String helloWorldInternationalised() {

        Locale locale = LocaleContextHolder.getLocale();

        return messageSource.getMessage("good.morning.message",null,"Default Message",locale);


    }

}

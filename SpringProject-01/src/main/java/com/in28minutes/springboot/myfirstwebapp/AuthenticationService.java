package com.in28minutes.springboot.myfirstwebapp;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authenticate(String username, String password) {

        boolean isValidUserName = username.equalsIgnoreCase("raj");

        boolean isValidPassword = password.equalsIgnoreCase("dummy123");

        return isValidPassword && isValidUserName;
    }
}

package com.in28minutes.springboot.myfirstwebapp.login;

import com.in28minutes.springboot.myfirstwebapp.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class loginController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private AuthenticationService authenticationService;

    public loginController(AuthenticationService authenticationService) {
        super();
        this.authenticationService = authenticationService;
    }

    // Pass Data from Controller to Model (jsp)
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String goToLogin() {
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestParam String name, @RequestParam String password,ModelMap model) {

        model.put("name", name);
        model.put("password", password);

        if(authenticationService.authenticate(name,password)){
            return "welcome";
        }

        model.put("errorMessage", "Invalid credentials! Please Try Again.");
        return "login";
    }
}

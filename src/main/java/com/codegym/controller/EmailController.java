package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class EmailController {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private Pattern pattern;
    private Matcher matcher;

    public EmailController() {
        pattern = Pattern.compile(EMAIL_REGEX);
    }
    private boolean validate(String regex){
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
    @GetMapping
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("home");
        return modelAndView;
    }

    @GetMapping("/validate")
    public ModelAndView success(@RequestParam String email){
        ModelAndView modelAndView;
        boolean isValidated = validate(email);
        if(!isValidated){
            modelAndView = new ModelAndView("home");
            modelAndView.addObject("message","Invalid Email!");
        } else {
            modelAndView = new ModelAndView("success","email",email);
        }
        return modelAndView;
    }

}

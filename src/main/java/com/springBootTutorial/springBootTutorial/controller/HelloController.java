package com.springBootTutorial.springBootTutorial.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping(value = "/" , method = RequestMethod.GET)
    public String HelloWorld(){
        return "Spring Boot 1st Outputtttt2323" ;
    }
}

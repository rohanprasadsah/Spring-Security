package com.example.springsecurity.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/basicAuthentication")
    public String basicAuthentication(){
        return "Basic Authentication";
    }
    @GetMapping("/1")
    public String one(){
        return "One";
    }
    @GetMapping("/2")
    public String two(){
        return "Two";
    }
}

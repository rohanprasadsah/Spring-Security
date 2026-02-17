package com.example.springsecurity.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/basicAuthentication")
    @PreAuthorize("hasAuthority('WEATHER_DELETE')")
    public String basicAuthentication(){
        return "Basic Authentication";
    }

    @GetMapping("/1")
    @PreAuthorize("hasRole('USER')")
    public String one(){
        return "One";
    }

    @GetMapping("/2")
    @PreAuthorize("hasRole('ADMIN')")
    public String two(){
        return "Two";
    }

    @PostMapping("/admin")
    @PreAuthorize("hasAuthority('WEATHER_WRITE')")
    public String admin(){
        return "Only ADMIN can access";
    }

    @GetMapping("/user")
    @PreAuthorize("hasAuthority('WEATHER_READ')")
    public String user(){
        return "Both ADMIN & USER can access";
    }
}

package com.example.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springsecurity.entity.AuthRequest;
import com.example.springsecurity.util.JWTUtil;

@RestController
public class AuthController {
    @Autowired
    private AuthenticationManager am;

    @Autowired
    private JWTUtil ju;

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest ar){
        try {
            am.authenticate(new UsernamePasswordAuthenticationToken(ar.getUsername(), ar.getPassword()));
            return ju.generateToken(ar.getUsername());
        } catch (Exception e) {
            throw e;
        }
    }
}

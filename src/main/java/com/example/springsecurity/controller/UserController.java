package com.example.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RestController;

import com.example.springsecurity.dto.RegisterUserRequest;
import com.example.springsecurity.dto.UserResponse;
import com.example.springsecurity.entity.Role;
import com.example.springsecurity.service.UsersService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UsersService us;

    @PostMapping("/registerUser")
    public ResponseEntity<UserResponse> registerUser(@RequestBody RegisterUserRequest user) {
        user.setRole(Role.USER);
        return us.registerUser(user);
    }

    @PostMapping("/registerAdmin")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserResponse> registerAdmin(@RequestBody RegisterUserRequest user) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
System.out.println(auth.getAuthorities());
        return us.registerUser(user);
    }
    
}

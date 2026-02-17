package com.example.springsecurity.dto;

import com.example.springsecurity.entity.Role;

import lombok.Data;

@Data
public class RegisterUserRequest {
    private String username;
    private String password;
    private Role role;
}
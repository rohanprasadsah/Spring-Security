package com.example.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.springsecurity.dto.RegisterUserRequest;
import com.example.springsecurity.dto.UserResponse;
import com.example.springsecurity.entity.Users;
import com.example.springsecurity.repository.UsersRepository;

@Service
public class UsersService {
    @Autowired
    private UsersRepository ur;

    @Autowired
    private PasswordEncoder pe;

    public ResponseEntity<UserResponse> registerUser(RegisterUserRequest registerUserRequest){
        if(ur.findByUsername(registerUserRequest.getUsername()).isPresent()){
            throw new RuntimeException("User already exists");
        }
        Users user=new Users();
        user.setUsername(registerUserRequest.getUsername());
        user.setRole(registerUserRequest.getRole());
        user.setPassword(pe.encode(registerUserRequest.getPassword())); 
        Users save = ur.save(user);
        UserResponse savedUser=new UserResponse(save.getId(), save.getUsername(), save.getRole().name());
        return new ResponseEntity<UserResponse>(savedUser, HttpStatus.OK);
    }
}

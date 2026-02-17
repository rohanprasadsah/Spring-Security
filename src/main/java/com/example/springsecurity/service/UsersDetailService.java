package com.example.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.springsecurity.repository.UsersRepository;

@Service
public class UsersDetailService implements UserDetailsService{
    @Autowired
    private UsersRepository us;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return us.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("Username not found exception"));
    }
    
}

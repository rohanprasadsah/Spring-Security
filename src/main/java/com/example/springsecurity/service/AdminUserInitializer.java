package com.example.springsecurity.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.springsecurity.entity.Role;
import com.example.springsecurity.entity.Users;
import com.example.springsecurity.repository.UsersRepository;

@Component
public class AdminUserInitializer {
    @Bean
        public CommandLineRunner createAdminUser(UsersRepository ur, PasswordEncoder pe){
            return args->{
                if(ur.findByUsername("Rohan").isEmpty()){
                    Users admin=new Users();
                    admin.setUsername("Rohan");
                    admin.setPassword(pe.encode("Rohan1234"));
                    admin.setRole(Role.ADMIN);
                    ur.save(admin);
                    System.out.println("Default User of ADMIN Role Created");
                }
            };
        }
}

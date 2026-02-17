package com.example.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.springsecurity.entity.City;
import com.example.springsecurity.repository.CityRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController

public class CityController {
    @Autowired
    private CityRepository cr;

    @PostMapping("/saveCity")
    @PreAuthorize("hasRole('ADMIN')")
    public String save(@RequestBody City city){
        // Get logged-in role
        String performed_by = SecurityContextHolder.getContext().getAuthentication().getName();
        city.setPerformed_by(performed_by);
        cr.save(city);
        return "data saved successfully";
    }

    @GetMapping("/getCity")
    @PostAuthorize("returnObject.performed_by==authentication.name")
    public City getCity(@RequestParam String city) {
        System.out.println("Auth user: " +
                SecurityContextHolder.getContext().getAuthentication().getName());
        return cr.findByCity(city).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "No such city found"));
    }
    
}

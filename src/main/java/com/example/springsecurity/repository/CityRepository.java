package com.example.springsecurity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springsecurity.entity.City;

@Repository
public interface CityRepository extends JpaRepository<City,Long>{
    Optional<City> findByCity(String performed_by);
}

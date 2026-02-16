package com.example.springsecurity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.springsecurity.entity.Users;

@Repository
@Component
public interface UsersRepository extends JpaRepository<Users,Long>{
    Optional<Users> findByUsername(String username);
}

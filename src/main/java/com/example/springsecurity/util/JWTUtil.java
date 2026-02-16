package com.example.springsecurity.util;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;

@Component
public class JWTUtil {
    @Value("${jwt.secretKey}")
    private String secret;

    private SecretKey key;
    
    @PostConstruct
    private void getSigningKey(){
        this.key=Keys.hmacShaKeyFor(secret.getBytes());
    }

    @Value("${jwt.expirationTime}")
    private long expirationTime;
    public String generateToken(String userName){
        return Jwts.builder()
                    .subject(userName)
                    .issuedAt(new Date())
                    .expiration(new Date(System.currentTimeMillis() + expirationTime))
                    .signWith(key)
                    .compact();
    }

    private Claims extractPayload(String token) {
        return Jwts.parser()
            .verifyWith(key)
            .build()
            .parseSignedClaims(token)
            .getPayload();
    }

    public String extractUsername(String token) {
        return extractPayload(token).getSubject();
    }

    public boolean validate(UserDetails userDetails, String userName, String token) {
        return userName.equals(userDetails.getUsername())&&!isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractPayload(token).getExpiration().before(new Date());
    }
}

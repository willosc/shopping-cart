package com.evaluation.shopping_cart.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AuthService {

    private static final String HARDCODED_USER = "admin";
    private static final String HARDCODED_PASS = "password";

    @Value("${jwt.secret}")
    private String secretKey;

    public String login(String username, String password) {
        if (HARDCODED_USER.equals(username) && HARDCODED_PASS.equals(password)) {
            return createToken(username);
        }
        throw new RuntimeException("Invalid credentials");
    }

    private String createToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 day
                .signWith(Keys.hmacShaKeyFor(secretKey.getBytes()), SignatureAlgorithm.HS256)
                .compact();
    }
}

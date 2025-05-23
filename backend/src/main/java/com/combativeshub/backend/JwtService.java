package com.combativeshub.backend;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JwtService {

    // 🔑 This should be moved to a secure config for production
    private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    // Valid for 24 hours (in ms)
    private static final long EXPIRATION_TIME = 1000 * 60 * 60 * 24;

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuer("combativeshub")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SECRET_KEY)
                .compact();
    }
}

package com.sakerini.tokenservice.service.impl;

import com.sakerini.tokenservice.service.TokenGeneratorService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TokenGeneratorServiceImpl implements TokenGeneratorService {

    @Value("${jwt.secret}")
    private String secretKey;

    /**
     * Generates a JWT token containing username as subject, and userId and role as additional claims. These properties are taken from the specified
     * User object. Tokens validity is infinite.
     *
     * @param username the username for which the token will be generated
     * @param role the role it user has in our system
     * @return the JWT token
     */
    @Override
    public String generateToken(String username, String role) {
        Claims claims = Jwts.claims().setSubject(username);
        claims.put("role", role);

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }
}

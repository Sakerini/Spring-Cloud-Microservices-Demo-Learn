package com.sakerini.tokenservice.service.impl;

import com.sakerini.tokenservice.service.TokenGeneratorService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenGeneratorServiceImpl implements TokenGeneratorService {

    @Value("${jwt.secret}")
    private String secretKey;

    private Long ONE_HOUR = 3600000L;
    /**
     * Generates a JWT token containing username as subject, role as additional claims. These properties are taken from the specified
     * User object. Tokens validity is infinite.
     *
     * @param username the username for which the token will be generated
     * @param role the role it user has in our system
     * @return the JWT token
     */
    @Override
    public String generateToken(String username, String role) {

        return Jwts.builder()
                .setSubject(username)
                .claim("role", role)
                .setIssuer("lololo")
                .setExpiration(calculateExpirationDate())
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    private Date calculateExpirationDate() {
        Date now = new Date();
        return new Date(now.getTime() + ONE_HOUR);
    }
}

package com.sakerini.tokenservice.service;

public interface TokenGeneratorService {
    String generateToken(String username, String role);
}

package com.sakerini.loginservice.entity.dto;

import lombok.Getter;

@Getter
public class CredentialDto {
    private String username;
    private String password;

    public CredentialDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Credential{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

package com.sakerini.loginservice.entity.dto;

import lombok.Getter;

@Getter
public class TokenDto {
    private int id;
    private String token;

    public TokenDto(int id, String token) {
        this.id = id;
        this.token = token;
    }
}

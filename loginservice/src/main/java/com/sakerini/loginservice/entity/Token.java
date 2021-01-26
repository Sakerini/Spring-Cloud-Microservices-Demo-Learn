package com.sakerini.loginservice.entity;

import lombok.Getter;

@Getter
public class Token {
    private int id;
    private String token;

    public Token(int id, String token) {
        this.id = id;
        this.token = token;
    }
}

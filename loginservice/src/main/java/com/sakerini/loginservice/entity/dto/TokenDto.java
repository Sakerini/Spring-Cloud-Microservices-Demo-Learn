package com.sakerini.loginservice.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TokenDto {
    private int id;
    private String token;

    @Override
    public String toString() {
        return "TokenDto{" +
                "id=" + id +
                ", token='" + token + '\'' +
                '}';
    }
}

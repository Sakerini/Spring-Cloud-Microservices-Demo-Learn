package com.sakerini.tokenservice.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "Token")
public class Token {

    @Id
    @SequenceGenerator(
            name = "token_sequence",
            sequenceName = "token_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "token_sequence")
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String Token;

    public Token() {
    }

    @Override
    public String toString() {
        return "Token{" +
                "id=" + id +
                ", userId=" + userId +
                ", username='" + username + '\'' +
                ", Token='" + Token + '\'' +
                '}';
    }
}

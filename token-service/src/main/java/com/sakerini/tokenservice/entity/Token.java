package com.sakerini.tokenservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity(name = "Token")
@NoArgsConstructor
@AllArgsConstructor
public class Token {

    @Id
    @SequenceGenerator(
            name = "token_sequence",
            sequenceName = "token_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "token_sequence")
    private Long id;

    @Column(
            unique = true,
            nullable = false)
    private String username;

    @Column(nullable = false)
    private String Token;

    @Override
    public String toString() {
        return "Token{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", Token='" + Token + '\'' +
                '}';
    }
}

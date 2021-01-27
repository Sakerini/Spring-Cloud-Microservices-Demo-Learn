package com.sakerini.loginservice.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "Credentials")
public class Credential {

    @Id
    @SequenceGenerator(
            name = "credential_sequence",
            sequenceName = "credential_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "credential_sequence")
    private Long id;

    @Column(unique = true,
            nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;

    public Credential(String username, String password) {
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

package com.sakerini.loginservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity(name = "Credentials")
@NoArgsConstructor
@AllArgsConstructor
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

    @Override
    public String toString() {
        return "Credential{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

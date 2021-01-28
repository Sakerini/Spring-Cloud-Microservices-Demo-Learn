package com.sakerini.cloudgateway.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserInformation {
    private String username;
    private String password;
    private String role;
}

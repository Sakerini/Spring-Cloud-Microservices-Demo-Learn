package com.sakerini.loginservice.service.impl;

import com.sakerini.loginservice.entity.Credential;
import com.sakerini.loginservice.entity.Token;
import com.sakerini.loginservice.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    private String username = "admin";
    private String password = "admin";

    @Override
    public boolean checkCredentials(Credential credential) {
        log.info("Inside checkCredentials in LoginService");
        if (credential.getUsername().equals(username)) {
            if (credential.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Token createToken(Credential credential) {
        log.info("Inside createToken in LoginService");
        return new Token(1, "123");
    }
}

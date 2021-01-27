package com.sakerini.loginservice.service.impl;

import com.sakerini.loginservice.entity.dto.CredentialDto;
import com.sakerini.loginservice.entity.dto.TokenDto;
import com.sakerini.loginservice.repository.CredentialRepository;
import com.sakerini.loginservice.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    private CredentialRepository credentialRepository;

    @Override
    public boolean checkCredentials(CredentialDto credential) {
        log.info("Inside checkCredentials in LoginService");
        if (credential.getUsername().equals(username)) {
            if (credential.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public TokenDto createToken(CredentialDto credential) {
        log.info("Inside createToken in LoginService");
        return new TokenDto(1, "123");
    }
}

package com.sakerini.loginservice.service.impl;

import com.sakerini.loginservice.entity.Credential;
import com.sakerini.loginservice.entity.dto.CredentialDto;
import com.sakerini.loginservice.entity.dto.TokenDto;
import com.sakerini.loginservice.repository.CredentialRepository;
import com.sakerini.loginservice.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    @Autowired
    private CredentialRepository credentialRepository;

    @Override
    public boolean checkCredentials(CredentialDto credentialDto) {
        Credential credential = credentialRepository.findByUsername(credentialDto.getUsername());
        if (credential != null) {
            if (credential.getPassword().equals(credentialDto.getPassword())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public TokenDto createToken(CredentialDto credentialDto) {
        log.info("Inside createToken in LoginService");
        return new TokenDto(1, "123");
    }
}

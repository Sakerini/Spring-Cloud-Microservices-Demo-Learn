package com.sakerini.loginservice.service;

import com.sakerini.loginservice.entity.Credential;
import com.sakerini.loginservice.entity.dto.CredentialRequestDto;
import com.sakerini.loginservice.entity.dto.TokenDto;

public interface LoginService {
    boolean checkCredentials(CredentialRequestDto credential);
    TokenDto getToken(String username, String role);
    Credential getCredentialByUsername(String username);
}

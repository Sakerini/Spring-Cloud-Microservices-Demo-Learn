package com.sakerini.loginservice.service;

import com.sakerini.loginservice.entity.Credential;
import com.sakerini.loginservice.entity.dto.CredentialDto;
import com.sakerini.loginservice.entity.dto.TokenDto;

public interface LoginService {
    public boolean checkCredentials(CredentialDto credential);
    public TokenDto createToken(CredentialDto credential);
}

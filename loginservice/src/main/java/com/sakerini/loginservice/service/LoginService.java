package com.sakerini.loginservice.service;

import com.sakerini.loginservice.entity.Credential;
import com.sakerini.loginservice.entity.Token;

public interface LoginService {
    public boolean checkCredentials(Credential credential);
    public Token createToken(Credential credential);
}

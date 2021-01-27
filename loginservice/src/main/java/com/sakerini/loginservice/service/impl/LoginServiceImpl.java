package com.sakerini.loginservice.service.impl;

import com.sakerini.loginservice.entity.Credential;
import com.sakerini.loginservice.entity.dto.CredentialDto;
import com.sakerini.loginservice.entity.dto.TokenDto;
import com.sakerini.loginservice.repository.CredentialRepository;
import com.sakerini.loginservice.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    @Autowired
    private CredentialRepository credentialRepository;

    @Autowired
    private RestTemplate restTemplate;

    private final String TOKEN_SERVICE_GET_URL = "http://localhost:3002/token/get-token/";

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
    public Credential getCredentialByUsername(String username) {
        return credentialRepository.findByUsername(username);
    }

    @Override
    public TokenDto getToken(String username, String role) {
        log.info("Inside createToken in LoginService");

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(TOKEN_SERVICE_GET_URL)
                .queryParam("username", username)
                .queryParam("role", role);

        TokenDto token = restTemplate.getForObject(uriBuilder.toUriString(), TokenDto.class);

        return token;
    }
}

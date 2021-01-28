package com.sakerini.loginservice.controller;

import com.sakerini.loginservice.entity.Credential;
import com.sakerini.loginservice.entity.dto.CredentialRequestDto;
import com.sakerini.loginservice.entity.dto.CredentialResponseDto;
import com.sakerini.loginservice.entity.dto.TokenDto;
import com.sakerini.loginservice.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/authorize")
    public ResponseEntity<TokenDto> login(@RequestBody CredentialRequestDto credential) {
        // Check credentials
        log.info("Inside loginservice /login/authorize");
        if (loginService.checkCredentials(credential)) {
            ResponseEntity<TokenDto> entity =
                    new ResponseEntity(
                            loginService.getToken(
                                    credential.getUsername(),
                                    loginService.getCredentialByUsername(credential.getUsername()).getRole()),
                            HttpStatus.OK);
            return entity;
        } else
            return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/find-user/{username}")
    public ResponseEntity<CredentialResponseDto> findUser(@PathVariable String username) {
        log.info("Inside login find user");
        Credential credential = loginService.getCredentialByUsername(username);
        if (!Objects.isNull(credential)) {
            ResponseEntity<CredentialResponseDto> responseDto =
                    new ResponseEntity(
                            new CredentialResponseDto(credential.getUsername(), credential.getPassword(), credential.getRole()),
                            HttpStatus.OK);

            return responseDto;
        } else {
            return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
        }
    }
}

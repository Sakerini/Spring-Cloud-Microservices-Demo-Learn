package com.sakerini.loginservice.controller;

import com.sakerini.loginservice.entity.dto.CredentialDto;
import com.sakerini.loginservice.entity.dto.TokenDto;
import com.sakerini.loginservice.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/get-token")
    public ResponseEntity<TokenDto> login(@RequestBody CredentialDto credential) {
        // Check credentials
        log.info("Inside loginservice /login/get-token");
        if (loginService.checkCredentials(credential)) {
            ResponseEntity<TokenDto> entity = new ResponseEntity(loginService.getToken(credential.getUsername()), HttpStatus.OK);
            return entity;
        } else
            return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
    }
}

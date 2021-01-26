package com.sakerini.loginservice.controller;

import com.sakerini.loginservice.entity.Credential;
import com.sakerini.loginservice.entity.Token;
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
    public ResponseEntity<Token> login(@RequestBody Credential credential) {
        // Check credentials
        log.info("Inside loginservice /login/get-token");
        if (loginService.checkCredentials(credential)) {
            ResponseEntity<Token> entity = new ResponseEntity(loginService.createToken(credential), HttpStatus.OK);
            return entity;
        } else
            return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
    }
}

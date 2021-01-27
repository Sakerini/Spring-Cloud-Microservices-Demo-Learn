package com.sakerini.tokenservice.controller;

import com.sakerini.tokenservice.entity.Token;
import com.sakerini.tokenservice.entity.dto.TokenDto;
import com.sakerini.tokenservice.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/token")
public class TokenController {

    @Autowired
    private TokenRepository tokenRepository;

    @GetMapping("/get-token")
    public ResponseEntity<TokenDto> getToken(@RequestParam String username, @RequestParam Long id) {
        Token token = new Token();
        token.setUsername(username);
        token.setUserId(id);
        //todo Add token generator!!!
        token.setToken("abcd");
        tokenRepository.save(token);
        ResponseEntity<TokenDto> response = new ResponseEntity(token, HttpStatus.OK);
        return response;
    }
}

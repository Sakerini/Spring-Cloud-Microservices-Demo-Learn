package com.sakerini.cloudgateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {

    @GetMapping("/login-service-fallback")
    public String loginServiceFallBack() {
        return "Login Service is taking longer than Excepted." +
                " Please try again later";
    }

    @GetMapping("/token-service-fallback")
    public String tokenServiceFallBack() {
        return "Token Service is taking longer than Excepted." +
                " Please try again later";
    }
}

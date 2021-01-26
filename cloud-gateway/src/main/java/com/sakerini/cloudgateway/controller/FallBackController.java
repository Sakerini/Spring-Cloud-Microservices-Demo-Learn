package com.sakerini.cloudgateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {

    @GetMapping("/login-service-fallback")
    public String loginServiceFallBack() {
        return "User Service is taking longer than Excepted." +
                " Please try again later";
    }
}

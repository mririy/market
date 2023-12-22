package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// AuthenticationController.java
@RestController
public class AuthenticationController {
    @Autowired
    private AuthenticationService authService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam(name = "email") String email, 
                                        @RequestParam(name = "password") String password) {
        if (authService.authenticate(email, password)) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed");
        }
    }
}



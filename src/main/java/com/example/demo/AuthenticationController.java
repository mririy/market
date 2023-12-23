package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthenticationController {
    
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    private AuthenticationService authService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam(name = "email") String email, 
                                        @RequestParam(name = "password") String password) {
        logger.info("Attempt to login with email: {}", email);

        if (authService.authenticate(email, password)) {
            logger.info("Authentication successful for email: {}", email);
            if (email.equals("admin@example.com")) {
                return ResponseEntity.ok()
                        .contentType(MediaType.TEXT_PLAIN)
                        .body("success");
            } else {
                return ResponseEntity.ok()
                        .contentType(MediaType.TEXT_PLAIN)
                        .body("visitor");
            }
        } else {
            logger.info("Authentication failed for email: {}", email);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .contentType(MediaType.TEXT_PLAIN)
                    .body("login-failed");
        }
    }
}

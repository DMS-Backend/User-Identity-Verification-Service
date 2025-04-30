package com.example.hello_world_auth.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class ApiController {

    @GetMapping("/hello")
    public String helloEndpoint() {
        log.info("Accessed /api/hello endpoint");
        return "Hello, authenticated user!";
    }
    
    @GetMapping("/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String adminEndpoint() {
        log.info("Accessed /api/admin endpoint");
        return "Hello, admin user!";
    }
    
    @GetMapping("/user")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String userEndpoint() {
        log.info("Accessed /api/user endpoint");
        return "Hello, regular user!";
    }
}
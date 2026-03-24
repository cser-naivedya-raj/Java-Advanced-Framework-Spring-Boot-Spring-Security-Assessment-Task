package com.capgemini.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.capgemini.model.entity.Student;
import com.capgemini.model.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public String register(@RequestBody Student student) {
        return authService.register(student);
    }

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> data) {
        return authService.login(data.get("email"), data.get("password"));
    }
}
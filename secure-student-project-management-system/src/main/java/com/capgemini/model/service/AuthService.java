package com.capgemini.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.capgemini.model.entity.Student;
import com.capgemini.model.repository.StudentRepository;
import com.capgemini.model.security.JwtUtil;

@Service
public class AuthService {

    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtUtil jwtUtil;

    public String register(Student student) {

        student.setPassword(passwordEncoder.encode(student.getPassword()));
        studentRepo.save(student);

        return "Student Registered Successfully";
    }

    public String login(String email, String password) {

        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
        );

        return jwtUtil.generateToken(email);
    }
}
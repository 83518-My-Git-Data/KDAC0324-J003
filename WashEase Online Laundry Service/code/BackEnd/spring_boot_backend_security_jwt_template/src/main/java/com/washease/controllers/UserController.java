package com.washease.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.washease.dto.LoginRequestDto;
import com.washease.dto.PasswordResetDto;
import com.washease.dto.PasswordResetRequestDto;
import com.washease.dto.UserRequestDto;
import com.washease.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService uservice;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRequestDto userdto) {
        System.out.println("CON" + userdto);
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(uservice.saveUser(userdto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @PostMapping("password/forgot")
    public ResponseEntity<String> forgotPassword(@RequestBody PasswordResetRequestDto requestDto) {
        uservice.generateResetToken(requestDto.getEmail());
        return ResponseEntity.ok("Reset token generated and sent to email.");
    }

    @PostMapping("password/reset")
    public ResponseEntity<String> resetPassword(@RequestBody PasswordResetDto resetDto) {
        uservice.resetPassword(resetDto.getToken(), resetDto.getNewPassword());
        return ResponseEntity.ok("Password successfully reset.");
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> signInUser(@RequestBody @Valid LoginRequestDto request) {
        System.out.println("in signin " + request);
        return ResponseEntity.ok(uservice.authenticateUser(request));
    }

   
}

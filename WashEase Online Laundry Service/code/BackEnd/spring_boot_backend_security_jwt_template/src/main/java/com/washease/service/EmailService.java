package com.washease.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendResetTokenEmail(String toEmail, String token) {
        String subject = "Password Reset Request";
        String message = "You requested a password reset. Use the following token to reset your password: \n\n" + token + 
                         "\n\nIf you did not request this, please ignore this email.";

        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(toEmail);
        email.setSubject(subject);
        email.setText(message);
        
        mailSender.send(email);
    }
}

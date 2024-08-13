package com.washease.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.washease.dao.UserDao;
import com.washease.dto.ApiResponse;
import com.washease.dto.EditUserDto;
import com.washease.dto.LoginRequestDto;
import com.washease.dto.UserRequestDto;
import com.washease.dto.UserResponseDto;
import com.washease.entities.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao udao;
    
    @Autowired
    private EmailService emailService;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

  
    public ApiResponse saveUser(UserRequestDto userdto) {
        User user = mapper.map(userdto, User.class);
        user.setRegistrationDate(new Date()); // Set the registration date separately
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Encode the password before saving
        User savedUser = udao.save(user);
        return new ApiResponse("User Registered for Id: " + savedUser.getUserId());
    }

    @Override
    public ApiResponse authenticateUser(LoginRequestDto dto) {
        Optional<User> userOptional = udao.findByEmail(dto.getEmail());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
                return new ApiResponse("User Logged In with Id: " + user.getUserId());
            } else {
                return new ApiResponse("Authentication failed: Invalid Email or Password.");
            }
        } else {
            return new ApiResponse("Authentication failed: User not found.");
        }
    }
    
    public void generateResetToken(String email) {
        Optional<User> userOptional = udao.findByEmail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            String token = UUID.randomUUID().toString();
            user.setResetToken(token);
            user.setResetTokenExpiry(new Date(System.currentTimeMillis() + 3600000)); // 1 hour expiry
            udao.save(user);
            
            // Send the reset token via email
            emailService.sendResetTokenEmail(email, token);
        } else {
            throw new RuntimeException("User not found with email: " + email);
        }
    }
    
    @Override
    public List<UserResponseDto> getAllUsers() {
        List<User> users = udao.findAll();
        return users.stream()
                    .map(user -> mapper.map(user, UserResponseDto.class))
                    .collect(Collectors.toList());
    }
    
    public void resetPassword(String token, String newPassword) {
        Optional<User> userOptional = udao.findByResetToken(token);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (user.getResetTokenExpiry().after(new Date())) {
                user.setPassword(passwordEncoder.encode(newPassword)); // Encode the new password before saving
                user.setResetToken(null);
                user.setResetTokenExpiry(null);
                udao.save(user);
            } else {
                throw new RuntimeException("Reset token has expired.");
            }
        } else {
            throw new RuntimeException("Invalid reset token.");
        }
    }

    
    @Override
    public User updateUser(Long id, EditUserDto editUserDto) {
        User user = udao.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setUsername(editUserDto.getUsername());
        user.setEmail(editUserDto.getEmail());
        user.setPhoneNumber(editUserDto.getPhoneNumber());
        return udao.save(user);
    }
    
    @Override
    public void deleteUser(Long id) {
    	udao.deleteById(id);
    }
   
}

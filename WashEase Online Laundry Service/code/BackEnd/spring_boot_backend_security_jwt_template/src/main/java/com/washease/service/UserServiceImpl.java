package com.washease.service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.washease.dao.UserDao;
import com.washease.dto.ApiResponse;
import com.washease.dto.UserRequestDto;
import com.washease.entities.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao udao;

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


   
}

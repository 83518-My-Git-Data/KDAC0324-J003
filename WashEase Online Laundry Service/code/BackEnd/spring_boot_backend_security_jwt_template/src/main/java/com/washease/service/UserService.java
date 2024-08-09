package com.washease.service;

import com.washease.dto.ApiResponse;
import com.washease.dto.LoginRequestDto;
import com.washease.dto.UserRequestDto;

public interface UserService {

	ApiResponse saveUser(UserRequestDto userdto);

	ApiResponse authenticateUser(LoginRequestDto dto);
}

package com.washease.service;

import java.util.List;

import com.washease.dto.ApiResponse;
import com.washease.dto.EditUserDto;
import com.washease.dto.LoginRequestDto;
import com.washease.dto.UserRequestDto;
import com.washease.dto.UserResponseDto;
import com.washease.entities.User;

public interface UserService {

	ApiResponse saveUser(UserRequestDto userdto);

	ApiResponse authenticateUser(LoginRequestDto dto);
	public void generateResetToken(String email);
	public void resetPassword(String token, String newPassword);
	public void deleteUser(Long id);
	public User updateUser(Long id, EditUserDto editUserDto);
	List<UserResponseDto> getAllUsers();
}

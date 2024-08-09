package com.washease.dto;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoginRequestDto {
	@NotEmpty(message = "Email must be supplied")
	@Email(message = "Invalid email format")
	private String email;
	@NotEmpty(message = "Password must be supplied")
	private String password;

}

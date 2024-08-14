package com.washease.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.washease.dto.LoginRequestDto;
import com.washease.dto.PasswordResetDto;
import com.washease.dto.PasswordResetRequestDto;
import com.washease.dto.SigninRequest;
import com.washease.dto.SigninResponse;
import com.washease.dto.UserRequestDto;
import com.washease.security.JwtUtils;
import com.washease.service.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@Autowired
	private AuthenticationManager authMgr;
	
	@Autowired
	private UserService uservice;

	/*
	 * URL - http://host:port/users/signin Method - POST request payload : Auth req
	 * DTO : email n password resp payload : In case of success : Auth Resp DTO :
	 * mesg + JWT token + SC 201 In case of failure : SC 401
	 * 
	 */
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@RequestBody 
			@Valid SigninRequest request) {
		System.out.println("in sign in" + request);
		//create a token to store un verified user email n pwd
		UsernamePasswordAuthenticationToken token=new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword());
		//invoke auth mgr's authenticate method;
		Authentication verifiedToken = authMgr.authenticate(token);
		//=> auth successful !
		System.out.println(verifiedToken.getPrincipal().getClass());//custom user details object
		//create JWT n send it to the clnt in response
		SigninResponse resp=new SigninResponse
				(jwtUtils.generateJwtToken(verifiedToken),
				"Successful Auth!!!!");
		return ResponseEntity.
				status(HttpStatus.CREATED).body(resp);
	}

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
    
  

   
}

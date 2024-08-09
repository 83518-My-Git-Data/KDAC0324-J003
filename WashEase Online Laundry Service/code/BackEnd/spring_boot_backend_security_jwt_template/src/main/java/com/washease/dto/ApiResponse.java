package com.washease.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//DTO :  resp DTO : to send API resp from rest server ---> rest clnt
@NoArgsConstructor
@Getter
@Setter
public class ApiResponse {
	private LocalDateTime timeStamp;
	private String message;
	//private String redirectUrl;
	public ApiResponse(String message) {
		super();
		this.message = message;
		this.timeStamp=LocalDateTime.now();
	}
//	public ApiResponse(String message, String redirectUrl) {
//        this.message = message;
//        this.redirectUrl = redirectUrl;
//        this.timeStamp = LocalDateTime.now();
//    }
}

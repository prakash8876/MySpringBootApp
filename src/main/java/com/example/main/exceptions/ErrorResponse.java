package com.example.main.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class ErrorResponse {
	
	private HttpStatus status;
	private String message;
	private LocalDateTime timeStamp;
	private int code;
	
	
	
}

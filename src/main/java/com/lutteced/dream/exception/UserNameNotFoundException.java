package com.lutteced.dream.exception;

public class UserNameNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	private String message;
	
	public UserNameNotFoundException() {
		// no-args constructor
	}

	public UserNameNotFoundException(String message) {
		this.message=message;
	}
}
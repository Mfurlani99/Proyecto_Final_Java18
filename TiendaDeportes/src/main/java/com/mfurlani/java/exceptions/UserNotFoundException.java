package com.mfurlani.java.exceptions;

public class UserNotFoundException extends Exception{

	private static final long serialVersionUID = 547825741305121528L;
	
	public UserNotFoundException(String message) {
		super(message);
	}

}

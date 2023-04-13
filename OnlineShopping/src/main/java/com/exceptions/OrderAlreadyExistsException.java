package com.exceptions;

public class OrderAlreadyExistsException extends RuntimeException{
public OrderAlreadyExistsException() {
		
	}
	
	public OrderAlreadyExistsException(String message) {
		super(message);
	}
}

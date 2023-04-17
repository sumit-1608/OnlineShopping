package com.exceptions;

public class OrderAlreadyExistsException extends RuntimeException{
	private static final long serialVersionUID = 1L;
public OrderAlreadyExistsException() {
		
	}
	
	public OrderAlreadyExistsException(String message) {
		super(message);
	}
}

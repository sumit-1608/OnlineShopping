package com.exceptions;

public class CartAlreadyExistsException extends RuntimeException{

private static final long serialVersionUID = 1L;
	
	public CartAlreadyExistsException() {
		
	}
	
	public CartAlreadyExistsException(String message) {
		super(message);
	}
}

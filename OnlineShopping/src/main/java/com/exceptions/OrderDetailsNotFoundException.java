package com.exceptions;

public class OrderDetailsNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public OrderDetailsNotFoundException(String message) {
		super(message);
	}
	public OrderDetailsNotFoundException() {
		

	}
	


}

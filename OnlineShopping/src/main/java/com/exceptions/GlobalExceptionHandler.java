package com.exceptions;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@Value(value="${data.exception.message1}")
    private String message1;
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException ex){
        return new ResponseEntity<>(message1, HttpStatus.NOT_FOUND);
    }

    @Value(value="${data.exception.message2}")
    private String message2;
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleProductNotFoundException(ProductNotFoundException ex){
        return new ResponseEntity<>(message2, HttpStatus.NOT_FOUND);
    }

    @Value(value="${data.exception.message3}")
    private String message3;
    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<String> handleItemNotFoundException(ItemNotFoundException ex){
        return new ResponseEntity<>(message3, HttpStatus.NOT_FOUND);
    }

    @Value(value="${data.exception.message4}")
    private String message4;
    @ExceptionHandler(OrderDetailsNotFoundException.class)
    public ResponseEntity<String> handleOrderDetailsNotFoundException(OrderDetailsNotFoundException ex){
        return new ResponseEntity<>(message4, HttpStatus.NOT_FOUND);
    }
}

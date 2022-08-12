package com.pragma.person.infrastructure.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor {
	
	@ExceptionHandler(PersonExistsException.class)
	public ResponseEntity<ExceptionObject> handlePersonExistsException(PersonExistsException exception) {
		ExceptionObject exceptionResponse = new ExceptionObject();
		exceptionResponse.setStatusCode(HttpStatus.CONFLICT.value());
		exceptionResponse.setMessage(exception.getMessage());
		exceptionResponse.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<ExceptionObject>(exceptionResponse, HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(PersonNotFoundException.class)
	public ResponseEntity<ExceptionObject> handlePersonNotFoundException(PersonNotFoundException exception) {
		ExceptionObject exceptionResponse = new ExceptionObject();
		exceptionResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
		exceptionResponse.setMessage(exception.getMessage());
		exceptionResponse.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<ExceptionObject>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
}

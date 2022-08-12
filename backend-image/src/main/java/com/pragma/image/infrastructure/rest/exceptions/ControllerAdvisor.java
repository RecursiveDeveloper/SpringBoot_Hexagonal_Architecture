package com.pragma.image.infrastructure.rest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor {
	
	@ExceptionHandler(ImageExistsException.class)
	public ResponseEntity<ExceptionObject> handleImageExistsException(ImageExistsException exception) {
		ExceptionObject exceptionResponse = new ExceptionObject();
		exceptionResponse.setStatusCode(HttpStatus.CONFLICT.value());
		exceptionResponse.setMessage(exception.getMessage());
		exceptionResponse.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<ExceptionObject>(exceptionResponse, HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(ImageNotFoundException.class)
	public ResponseEntity<ExceptionObject> handleImageNotFoundException(ImageNotFoundException exception) {
		ExceptionObject exceptionResponse = new ExceptionObject();
		exceptionResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
		exceptionResponse.setMessage(exception.getMessage());
		exceptionResponse.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<ExceptionObject>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ImageFileNotFound.class)
	public ResponseEntity<ExceptionObject> handleImageFileNotFound(ImageFileNotFound exception) {
		ExceptionObject exceptionResponse = new ExceptionObject();
		exceptionResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		exceptionResponse.setMessage(exception.getMessage());
		exceptionResponse.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<ExceptionObject>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

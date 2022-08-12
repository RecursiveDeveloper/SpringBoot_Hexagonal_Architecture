package com.pragma.image.infrastructure.rest.exceptions;

@SuppressWarnings("serial")
public class ImageNotFoundException extends RuntimeException {
	
	public ImageNotFoundException() {}
	
	public ImageNotFoundException(String message) {
		super(message);
	}
}

package com.pragma.image.infrastructure.rest.exceptions;

@SuppressWarnings("serial")
public class ImageExistsException extends RuntimeException {
	
	public ImageExistsException() {}
	
	public ImageExistsException(String message) {
		super(message);
	}
}

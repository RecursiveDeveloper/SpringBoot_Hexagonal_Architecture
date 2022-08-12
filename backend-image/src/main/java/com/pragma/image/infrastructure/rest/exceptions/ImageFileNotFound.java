package com.pragma.image.infrastructure.rest.exceptions;

@SuppressWarnings("serial")
public class ImageFileNotFound extends RuntimeException {
	
	public ImageFileNotFound() {}
	
	public ImageFileNotFound(String message) {
		super(message);
	}
}

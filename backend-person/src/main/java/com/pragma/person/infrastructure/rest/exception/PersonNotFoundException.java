package com.pragma.person.infrastructure.rest.exception;

@SuppressWarnings("serial")
public class PersonNotFoundException extends RuntimeException {
	
	public PersonNotFoundException(String message) {
		super(message);
	}
}

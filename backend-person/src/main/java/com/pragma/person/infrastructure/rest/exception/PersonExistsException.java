package com.pragma.person.infrastructure.rest.exception;

@SuppressWarnings("serial")
public class PersonExistsException extends RuntimeException {

	public PersonExistsException(String message) {
		super(message);
	}
}

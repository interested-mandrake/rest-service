package com.interestedmandrake.restservice.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AuthorNotFoundException extends RuntimeException {
	
	public AuthorNotFoundException(String message) {
		super(message);
	}
}
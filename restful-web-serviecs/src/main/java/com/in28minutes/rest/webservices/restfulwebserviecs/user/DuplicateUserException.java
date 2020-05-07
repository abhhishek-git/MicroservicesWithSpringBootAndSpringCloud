package com.in28minutes.rest.webservices.restfulwebserviecs.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicateUserException extends RuntimeException {

	public DuplicateUserException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	
}

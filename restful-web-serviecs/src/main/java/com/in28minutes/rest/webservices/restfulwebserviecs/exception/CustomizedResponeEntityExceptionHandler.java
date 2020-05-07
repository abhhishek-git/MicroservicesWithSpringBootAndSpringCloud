package com.in28minutes.rest.webservices.restfulwebserviecs.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.in28minutes.rest.webservices.restfulwebserviecs.user.DuplicateUserException;
import com.in28minutes.rest.webservices.restfulwebserviecs.user.UserNotFoundException;

@ControllerAdvice
@RestController
public class CustomizedResponeEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class) 
	final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) throws Exception {
		
		 ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));	 
		 return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	 }

	
	@ExceptionHandler(UserNotFoundException.class) 
	final ResponseEntity<Object> handleUserNotFoundExceptions(UserNotFoundException ex, WebRequest request) throws Exception {
		
		 ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));	 
		 return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
		 
	 }
	
	@ExceptionHandler(DuplicateUserException.class) 
	final ResponseEntity<Object> handleDuplicateUserExceptions(DuplicateUserException ex, WebRequest request) throws Exception {
		
		 ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));	 
		 return new ResponseEntity(exceptionResponse, HttpStatus.CONFLICT);
		 
	 }
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "Validation Failed", ex.getBindingResult().toString());
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

}

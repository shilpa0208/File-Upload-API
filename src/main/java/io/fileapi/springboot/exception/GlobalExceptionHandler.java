package io.fileapi.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler{
	
	@ExceptionHandler(value=InvalidInputException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public void invalidInputError(InvalidInputException e) {
		//can redirect to any view page
	}
		
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public void errorMessage(Exception ex){
		//Usually we redirect the error to its respective error view page. 
	}
	
	
}

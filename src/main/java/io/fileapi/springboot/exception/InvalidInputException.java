/**
 * 
 */
package io.fileapi.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Custom exception class
@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Invalid id")
public class InvalidInputException extends Exception{
	
	public InvalidInputException(Integer id) {
		super("There is no file with the id "+ id);
	}
	

}

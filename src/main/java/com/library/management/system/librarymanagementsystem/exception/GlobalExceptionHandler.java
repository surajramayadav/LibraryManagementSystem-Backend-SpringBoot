package com.library.management.system.librarymanagementsystem.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@ControllerAdvice
public class GlobalExceptionHandler {
    
	final Logger logger = LogManager.getLogger(GlobalExceptionHandler.class);
		

    // handling specific exception
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Object> resourceNotFoundHandling(ResourceNotFoundException exception, WebRequest request){
        ErrorMessage errorDetails = 
        new ErrorMessage(false, exception.getMessage(),request.getDescription(false), new Date());
		logger.error(exception.getMessage());
		return new ResponseEntity<Object>(errorDetails, HttpStatus.NOT_FOUND);
	}

	// handling global exception
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> globalExceptionHandling(Exception exception, WebRequest request){
		ErrorMessage errorDetails = 
				new ErrorMessage(false, exception.getMessage(),request.getDescription(false), new Date());
				logger.error(exception.getMessage());
		return new ResponseEntity<Object>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

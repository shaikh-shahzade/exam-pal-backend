package com.exampal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.exampal.model.ApiResponse;

@RestControllerAdvice
public class ExceptionController {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceNotFound(ResourceNotFoundException exp)
	{
		return new ResponseEntity<ApiResponse>(new ApiResponse(exp.getMessage(),false) , HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UnuthorizedAccessException.class)
	public ResponseEntity<ApiResponse> unAuthorisedAccess(UnuthorizedAccessException exp)
	{
		return new ResponseEntity<ApiResponse>(new ApiResponse(exp.getMessage(),false) , HttpStatus.NOT_FOUND);
	}
}

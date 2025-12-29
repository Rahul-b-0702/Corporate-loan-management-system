package com.examly.springapp.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	public static class ApiError {
		public LocalDateTime timestamp = LocalDateTime.now();
		public int status;
		public String error;
		public String message;

		public ApiError(HttpStatus status, String message) {
			this.status = status.value();
			this.error = status.getReasonPhrase();
			this.message = message;
		}
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiError> handleNotFound(ResourceNotFoundException ex) {
		ApiError err = new ApiError(HttpStatus.NOT_FOUND, ex.getMessage());
		return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
	}
 
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiError> handleOther(Exception ex) {
		ApiError err = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
		return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
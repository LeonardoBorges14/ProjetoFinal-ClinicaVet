package com.vet.resource.exception;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.vet.service.exception.DeleteNotAllowedException;
import com.vet.service.exception.InsertNotAllowedException;
import com.vet.service.exception.ResourceNotFoundException;
import com.vet.service.exception.UpdateNotAllowedException;

	@ControllerAdvice
	public class ResourceExceptionHandler {
		
		@ExceptionHandler(DeleteNotAllowedException.class)
		public ResponseEntity<StandardError> DeleteNotAllowedException(DeleteNotAllowedException e, HttpServletRequest request) {
			StandardError err = new StandardError();
			err.setTimestamp(Instant.now());
			err.setStatus(HttpStatus.NOT_FOUND.value());
			err.setError("Delete Exception");
			err.setMessage(e.getMessage());
			err.setPath(request.getRequestURI());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
		}
		
		@ExceptionHandler(InsertNotAllowedException.class)
		public ResponseEntity<StandardError> InsertNotAllowedException(InsertNotAllowedException e, HttpServletRequest request) {
			StandardError err = new StandardError();
			err.setTimestamp(Instant.now());
			err.setStatus(HttpStatus.BAD_REQUEST.value());
			err.setError("Insert exception");
			err.setMessage(e.getMessage());
			err.setPath(request.getRequestURI());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
		}
		
		@ExceptionHandler(UpdateNotAllowedException.class)
		public ResponseEntity<StandardError> UpdateNotAllowedException(UpdateNotAllowedException e, HttpServletRequest request) {
			StandardError err = new StandardError();
			err.setTimestamp(Instant.now());
			err.setStatus(HttpStatus.BAD_REQUEST.value());
			err.setError("Update exception");
			err.setMessage(e.getMessage());
			err.setPath(request.getRequestURI());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
		}
		
		@ExceptionHandler(ResourceNotFoundException.class)
		public ResponseEntity<StandardError> ResourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
			StandardError err = new StandardError();
			err.setTimestamp(Instant.now());
			err.setStatus(HttpStatus.NOT_FOUND.value());
			err.setError("Resource not found");
			err.setMessage(e.getMessage());
			err.setPath(request.getRequestURI());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
		}

	}


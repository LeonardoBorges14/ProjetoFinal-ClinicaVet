package com.vet.service.exception;

public class UpdateNotAllowedException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public UpdateNotAllowedException(String msg) {
		super(msg);
	}

}
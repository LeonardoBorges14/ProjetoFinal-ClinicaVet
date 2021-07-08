package com.vet.service.exception;

public class InsertNotAllowedException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public InsertNotAllowedException(String msg) {
		super(msg);
	}

}
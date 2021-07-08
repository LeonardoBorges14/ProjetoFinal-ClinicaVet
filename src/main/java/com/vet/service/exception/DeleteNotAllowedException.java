package com.vet.service.exception;

public class DeleteNotAllowedException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public DeleteNotAllowedException(String msg) {
		super(msg);
	}

}
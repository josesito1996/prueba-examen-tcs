package com.tcs.service.app.exception;

public class InternalErrorException extends RuntimeException {

	private static final long serialVersionUID = -3030033361730955263L;

	public InternalErrorException(String msg) {
		super(msg);
	}
	
}

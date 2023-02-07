package com.tcs.service.app.exception;

public class NotAuthorizedException extends RuntimeException{

	private static final long serialVersionUID = -6891656367907380369L;
	
	public NotAuthorizedException(String msg) {
		super(msg);
	}

}

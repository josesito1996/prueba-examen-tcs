package com.tcs.service.app.exception;

public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = -6353932741856358111L;

	public BadRequestException(String msg) {
		super(msg);
	}
	
}

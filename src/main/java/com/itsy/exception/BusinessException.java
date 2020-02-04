package com.itsy.exception;

public class BusinessException extends Exception {
	private static final long serialVersionUID = -4441528404904851218L;
	
	private String message;
	
	public BusinessException() {
		
	}
	public BusinessException(final String message) {
		this.message = message;
	}
}
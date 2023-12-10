package com.org.exception;

public class IdnotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public IdnotFoundException(String msg) {
		super(msg);
	}

}

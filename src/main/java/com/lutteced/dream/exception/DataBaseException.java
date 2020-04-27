package com.lutteced.dream.exception;

public class DataBaseException extends RuntimeException {
	private static final long serialVersionUID = 644797096423170810L;

	public DataBaseException() {
		// no-arg constructor
	}

	public DataBaseException(String message) {
		super(message);
	}

}
package com.aula.udemy.cursoudemy.exceptions;

public class DataIntegrityException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DataIntegrityException (String msg) {
		super(msg);
	}

	public DataIntegrityException(String msg, Throwable clause) {
		super(msg,clause);
	}
}

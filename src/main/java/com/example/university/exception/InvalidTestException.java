package com.example.university.exception;

public class InvalidTestException extends RuntimeException{
	private static final long serialVersionUID = -2016176758243219649L;

	public InvalidTestException() {
		super();
	}

	public InvalidTestException(String message) {
		super(message);
	}
}

package com.example.university.exception;

public class InvalidTeacherException extends RuntimeException{
	private static final long serialVersionUID = -2016176758243219649L;

	public InvalidTeacherException() {
		super();
	}

	public InvalidTeacherException(String message) {
		super(message);
	}
}

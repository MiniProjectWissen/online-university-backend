package com.example.university.exception;

public class InvalidCourseException extends RuntimeException{

	private static final long serialVersionUID = -2016176758243219649L;

	public InvalidCourseException() {
		super();
	}

	public InvalidCourseException(String message) {
		super(message);
	}
}

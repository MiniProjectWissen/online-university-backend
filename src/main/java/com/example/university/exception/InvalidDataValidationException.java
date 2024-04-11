package com.example.university.exception;

import java.util.List;

public class InvalidDataValidationException extends RuntimeException {
	private static final long serialVersionUID = -1381510345423867578L;
	private List<String> messages;

	public InvalidDataValidationException() {
		super();
	}

	public InvalidDataValidationException(List<String> messages) {
		super();
		this.messages = messages;
	}

	public List<String> getMsg() {
		return messages;
	}

}

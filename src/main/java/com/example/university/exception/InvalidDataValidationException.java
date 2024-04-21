package com.example.university.exception;

import java.io.Console;
import java.util.List;

import net.bytebuddy.asm.Advice.This;

public class InvalidDataValidationException extends RuntimeException {
	private static final long serialVersionUID = -1381510345423867578L;
	private List<String> messages;

	public InvalidDataValidationException() {
		super();
	}

	public InvalidDataValidationException(List<String> messages) {
		super();
//		System.out.println("super()");
		this.messages = messages;
		
	}

	public List<String> getMsg() {

		return this.messages;

	}

}

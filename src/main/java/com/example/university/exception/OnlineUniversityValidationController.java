package com.example.university.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class OnlineUniversityValidationController {

	@ExceptionHandler(value = InvalidStudentException.class)
	public ResponseEntity<Object> handleException(InvalidStudentException exception) {
		return new ResponseEntity<>(exception.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = InvalidTeacherException.class)
	public ResponseEntity<Object> handleException(InvalidTeacherException exception) {
		return new ResponseEntity<>(exception.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = InvalidCourseException.class)
	public ResponseEntity<Object> handleException(InvalidCourseException exception) {
		return new ResponseEntity<>(exception.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
	}
}

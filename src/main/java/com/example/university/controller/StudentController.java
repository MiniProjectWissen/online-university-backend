package com.example.university.controller;

import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.university.dto.StudentDTO;
import com.example.university.exception.InvalidDataValidationException;
import com.example.university.exception.InvalidStudentException;
import com.example.university.exception.InvalidTeacherException;
import com.example.university.service.IStudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private IStudentService studentService;
	
	@GetMapping("/get/all")
	public ResponseEntity<Object> listAllCourses() {
		return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Object> addCourse(@Valid @RequestBody StudentDTO s, BindingResult bindingResult)
	{
		if(bindingResult.hasErrors()) {
			System.out.println("Some errors exist");
			List<FieldError> fieldErrors = bindingResult.getFieldErrors();
			
			List<String> errMessage = new ArrayList<String>();
			for(FieldError fe : fieldErrors) {
				errMessage.add(fe.getDefaultMessage());
			}
			throw new InvalidDataValidationException(errMessage);
		}
		
		try {
			studentService.addStudent(s);
			return new ResponseEntity<>("Student added Successfully", HttpStatus.OK);
			
		} catch (InvalidStudentException e) {
			throw  new InvalidStudentException(e.getMessage());
		}
		
	}
	
	@PutMapping("/update/{studId}")
	public ResponseEntity<Object> updateCourse(@PathVariable Integer studId,@Valid @RequestBody StudentDTO s,BindingResult bindingResult)
	{
		if(bindingResult.hasErrors()) {
			System.out.println("Some errors exist");
			List<FieldError> fieldErrors = bindingResult.getFieldErrors();
			
			List<String> errMessage = new ArrayList<String>();
			for(FieldError fe : fieldErrors) {
				errMessage.add(fe.getDefaultMessage());
			}
			throw new InvalidDataValidationException(errMessage);
		}
		
		try {
			studentService.updateStudentByStudentId(studId,s);
			return new ResponseEntity<>("Student updated Successfully", HttpStatus.OK);
			
		} catch (InvalidStudentException e) {
			throw  new InvalidStudentException(e.getMessage()+"Stud Id error");
		}
		
	}
	
	@DeleteMapping("/delete/{course_id}")
	public ResponseEntity<Object> deleteCourse(@PathVariable Integer studId)
	{
		try {
			studentService.deleteStudentByStudentId(studId);
			return new ResponseEntity<>("Student deleted Successfully", HttpStatus.OK);
		}catch (InvalidStudentException e) {
			throw  new InvalidStudentException(e.getMessage()+"Stud Id error");
		}

	}
	
	@GetMapping("/get/{studId}")
	public ResponseEntity<Object> findByStudentId(@PathVariable Integer studId)
	{
		try {
			return new ResponseEntity<>(studentService.findByStudentId(studId), HttpStatus.OK);
			
		} catch (InvalidStudentException e) {
			throw  new InvalidStudentException(e.getMessage()+"Stud Id error");
		}
		
	}
	
}


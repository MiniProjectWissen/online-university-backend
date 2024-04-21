package com.example.university.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.university.dto.TestDTO;
import com.example.university.exception.InvalidDataValidationException;
import com.example.university.exception.InvalidTestException;
import com.example.university.service.ITestService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/test")
@CrossOrigin("http://localhost:4200")
public class TestController {

	@Autowired
	ITestService testService;
	
	@GetMapping("/get/all")
	public ResponseEntity<Object> listAllTests() {
		try {
			return new ResponseEntity<>(testService.getAllTests(), HttpStatus.OK);
			
		} catch (InvalidTestException e) {
			throw new InvalidTestException(e.getMessage());
		}
	}
	
	@PostMapping("/add")
	public ResponseEntity<Object> addTest(@Valid @RequestBody TestDTO c, BindingResult bindingResult )
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
			testService.createTest(c);
			return new ResponseEntity<>(Collections.singletonMap("msg","Test added successfully"), HttpStatus.OK);
			
		} catch (InvalidTestException e) {
			throw new InvalidTestException(e.getMessage());
		}
		
	}
	
	@PutMapping("/update/{user_id}")
	public ResponseEntity<Object> updateTest(@PathVariable Integer user_id,@Valid @RequestBody TestDTO c, BindingResult bindingResult)
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
			testService.updateTest(user_id, c);
			return new ResponseEntity<>(Collections.singletonMap("msg","Test updated successfully"), HttpStatus.OK);
		}
		 catch (InvalidTestException e) {
			throw new InvalidTestException(e.getMessage()+" Course Id error");
		}
	}
		
	
	@DeleteMapping("/delete/{course_id}")
	public ResponseEntity<Object> deleteCourse(@PathVariable Integer test_id)
	{
		try {
			testService.deleteTest(test_id);
			return new ResponseEntity<>(Collections.singletonMap("msg","Test deleted successfully"), HttpStatus.OK);
		}
		catch (InvalidTestException e) {
			throw new InvalidTestException(e.getMessage()+" Course Id error");
		}
	}
	
	@GetMapping("/get/{test_id}")
	public ResponseEntity<Object> findByTestId(@PathVariable Integer test_id)
	{
		try {
			return new ResponseEntity<>(testService.findByTestId(test_id), HttpStatus.OK);
		}
		catch (InvalidTestException e) {
			throw new InvalidTestException(e.getMessage()+" Test Id error");
		}
	}
	
	@GetMapping("/get/alltests/{course_id}")
	public ResponseEntity<Object> findTestsByCourse(@PathVariable Integer course_id)
	{
		try {
			return new ResponseEntity<>(testService.getTestsByCourse(course_id), HttpStatus.OK);
		}
		catch (InvalidTestException e) {
			throw new InvalidTestException(e.getMessage()+" Test Id error");
		}
	}
}

package com.example.university.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.university.dto.CourseDTO;
import com.example.university.exception.InvalidCourseException;
import com.example.university.exception.InvalidDataValidationException;
import com.example.university.exception.InvalidStudentException;
import com.example.university.service.ICourseService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	ICourseService courseService;
	
	@GetMapping("/get/all")
	public ResponseEntity<Object> listAllCourses() {
		try {
			return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.OK);
			
		} catch (InvalidCourseException e) {
			throw new InvalidCourseException(e.getMessage());
		}
		
	}
	
	@PostMapping("/add")
	public ResponseEntity<Object> addCourse(@Valid @RequestBody CourseDTO c, BindingResult bindingResult )
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
			courseService.addCourse(c);
			return new ResponseEntity<>("Course added Successfully", HttpStatus.OK);
			
		} catch (InvalidCourseException e) {
			throw new InvalidCourseException(e.getMessage());
		}
		
	}
	
	@PutMapping("/update/{user_id}")
	public ResponseEntity<Object> updateCourse(@PathVariable Integer user_id,@Valid @RequestBody CourseDTO c, BindingResult bindingResult)
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
			courseService.updateCourse(user_id, c);
			return new ResponseEntity<>("Course updated Successfully", HttpStatus.OK);
		}
		 catch (InvalidCourseException e) {
			throw new InvalidCourseException(e.getMessage()+" Course Id error");
		}
	}
		
	
	@DeleteMapping("/delete/{course_id}")
	public ResponseEntity<Object> deleteCourse(@PathVariable Integer course_id)
	{
		try {
			courseService.deleteCourseById(course_id);
			return new ResponseEntity<>("Course deleted Successfully", HttpStatus.OK);
		}
		catch (InvalidCourseException e) {
			throw new InvalidCourseException(e.getMessage()+" Course Id error");
		}
	}
	
	@GetMapping("/get/{course_id}")
	public ResponseEntity<Object> findByCourseId(@PathVariable Integer course_id)
	{
		try {
			return new ResponseEntity<>(courseService.findByCourseId(course_id), HttpStatus.OK);
		}
		catch (InvalidCourseException e) {
			throw new InvalidCourseException(e.getMessage()+" Course Id error");
		}
		
	}
	
	@PutMapping("/incrementLectureCount/{course_id}")
	public ResponseEntity<Object> incrementLectureCount(@PathVariable Integer course_id)
	{
		try {
			courseService.incrementLectureCount(course_id);
			return new ResponseEntity<>("Course Lecture Count incremented Successfully", HttpStatus.OK);
		}
		catch (InvalidCourseException e) {
			throw new InvalidCourseException(e.getMessage()+" Course Id error");
		}
		
		
	}
}

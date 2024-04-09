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

import com.example.university.dto.TeacherDTO;
import com.example.university.exception.InvalidDataValidationException;
import com.example.university.exception.InvalidTeacherException;
import com.example.university.service.ITeacherService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
	@Autowired
	ITeacherService teacherService;
	
	@PostMapping("/add")
	public ResponseEntity<Object> newTeacher(@jakarta.validation.Valid @RequestBody TeacherDTO teacherDto,BindingResult bindingResult){
		
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
			teacherService.createTeacher(teacherDto);
			return new ResponseEntity<>("teacher created successfully",HttpStatus.OK);
		}
		catch(InvalidTeacherException e) {
			throw  new InvalidTeacherException(e.getMessage());
		}
		
	}
	
	@GetMapping("/get/id/{teacherId}")
	public ResponseEntity<Object> findTeacherById(@PathVariable String teacherId){
		if(teacherId.isBlank()||teacherId.isEmpty()) {
			throw new InvalidTeacherException("Teacher Id is blank");
		}else {
			try {
				return new ResponseEntity<>(teacherService.getTeacher(Integer.parseInt(teacherId)), HttpStatus.OK);
			} catch(InvalidTeacherException e) {
				throw  new InvalidTeacherException(e.getMessage());
			}
		}
		
	}
	
	@GetMapping("/get/all")
	public ResponseEntity<Object> getTeacherList() {
		try {
			return new ResponseEntity<>(teacherService.getAllTeachers(), HttpStatus.OK);
		}
		catch (InvalidTeacherException e) {
			throw  new InvalidTeacherException(e.getMessage());
		}
	}
	
	@PutMapping("/update/{teacherId}")
	public ResponseEntity<Object> updateTeacher(@PathVariable String teacherId,
			 @Valid @RequestBody TeacherDTO teacherDTO, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			System.out.println("Some errors exist");
			List<FieldError> fieldErrors = bindingResult.getFieldErrors();
			
			List<String> errMessage = new ArrayList<String>();
			for(FieldError fe : fieldErrors) {
				errMessage.add(fe.getDefaultMessage());
			}
			throw new InvalidDataValidationException(errMessage);
		}
		if (teacherId.isBlank() || teacherId.isEmpty()) {
			throw new RuntimeException();
		} 
		try {
			teacherService.updateTeacher(Integer.parseInt(teacherId), teacherDTO);
			return new ResponseEntity<>("Updated Faculty Details Successfully!", HttpStatus.OK);
		} catch (InvalidTeacherException e) {
			throw  new InvalidTeacherException(e.getMessage());
		}
		
		
	}
	
	@DeleteMapping("/delete/{teacherId}")
	public ResponseEntity<Object> deleteFaculty(@PathVariable String teacherId) {
		if (teacherId.isBlank() || teacherId.isEmpty()) {
			throw new InvalidTeacherException("Teacher Id is blank");
		} else {
			try {
				teacherService.deleteTeacher(Integer.parseInt(teacherId));
				return new ResponseEntity<>("Deleted Teacher from Records Successfully!", HttpStatus.OK);
			} catch (InvalidTeacherException e) {
				throw  new InvalidTeacherException(e.getMessage());
			}
		}
		
	}
}

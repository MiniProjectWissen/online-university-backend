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
import com.example.university.service.ITeacherService;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
	@Autowired
	ITeacherService teacherService;
	
	@PostMapping("/add")
	public ResponseEntity<Object> newTeacher(@RequestBody TeacherDTO teacherDto,BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			System.out.println("Some errors exist");
			List<FieldError> fieldErrors = bindingResult.getFieldErrors();
			
			List<String> errMessage = new ArrayList<>();
			for(FieldError fe : fieldErrors) {
				errMessage.add(fe.getDefaultMessage());
			}
			throw new RuntimeException();
		}
		try {
			teacherService.createTeacher(teacherDto);
			return new ResponseEntity<>("teacher created successfully",HttpStatus.OK);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	@GetMapping("/get/id/{teacherId}")
	public ResponseEntity<Object> findTeacherById(@PathVariable String teacherId){
		if(teacherId.isBlank()||teacherId.isEmpty()) {
			throw new RuntimeException();
		}else {
			try {
				return new ResponseEntity<>(teacherService.getTeacher(Integer.parseInt(teacherId)), HttpStatus.OK);
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return null;
	}
	
	@GetMapping("/get/all")
	public ResponseEntity<Object> getTeacherList() {
		return new ResponseEntity<>(teacherService.getAllTeachers(), HttpStatus.OK);
	}
	
	@PutMapping("/update/{teacherId}")
	public ResponseEntity<Object> updateTeacher(@PathVariable String teacherId,
			 @RequestBody TeacherDTO teacherDTO, BindingResult bindingResult) {
		if (teacherId.isBlank() || teacherId.isEmpty()) {
			throw new RuntimeException();
		} else if (bindingResult.hasErrors()) {
			System.out.println("Some errors exist!");
			List<FieldError> fieldErrors = bindingResult.getFieldErrors();

			List<String> errMessages = new ArrayList<>();
			for (FieldError fe : fieldErrors) {
				errMessages.add(fe.getDefaultMessage());
			}
			throw new RuntimeException();
		}

		else {
			try {
				teacherService.updateTeacher(Integer.parseInt(teacherId), teacherDTO);
				return new ResponseEntity<>("Updated Faculty Details Successfully!", HttpStatus.OK);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return null;
	}
	
	@DeleteMapping("/delete/{teacherId}")
	public ResponseEntity<Object> deleteFaculty(@PathVariable String teacherId) {
		if (teacherId.isBlank() || teacherId.isEmpty()) {
			throw new RuntimeException();
		} else {
			try {
				teacherService.deleteTeacher(Integer.parseInt(teacherId));
				return new ResponseEntity<>("Deleted Teacher from Records Successfully!", HttpStatus.OK);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return null;
	}
}

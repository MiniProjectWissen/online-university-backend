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


import com.example.university.dto.StudentDTO;
import com.example.university.dto.Student_Course_MappingDTO;
import com.example.university.dto.Student_Test_MappingDTO;
import com.example.university.service.ICourseService;
import com.example.university.exception.InvalidCourseException;
import com.example.university.exception.InvalidDataValidationException;
import com.example.university.exception.InvalidStudentException;
import com.example.university.service.IStudentService;
import com.example.university.service.ITestService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/student")

@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {

	@Autowired
	private IStudentService studentService;
	
	@Autowired
	private ICourseService courseService;
	
	@Autowired
	private ITestService testService;
	
	@GetMapping("/get/all")
	public ResponseEntity<Object> listAllStudents() {
		return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
	}
	
	@GetMapping("/get/enrollCourses/{stud_id}")
	public ResponseEntity<Object> listAllCourses(@PathVariable int stud_id) {
		return new ResponseEntity<>(studentService.getAllEnrolledCourses(stud_id), HttpStatus.OK);
	}
	@PostMapping("/add")
	public ResponseEntity<Object> addStudent(@Valid @RequestBody StudentDTO s, BindingResult bindingResult)
	{
		if(bindingResult.hasErrors()) {
			System.out.println("Some errors exist");
			List<FieldError> fieldErrors = bindingResult.getFieldErrors();
			
			List<String> errMessage = new ArrayList<String>();
			for(FieldError fe : fieldErrors) {
				errMessage.add(fe.getDefaultMessage());
			}
//			System.out.println(errMessage);
			throw new InvalidDataValidationException(errMessage);
		}
		
		try {
			studentService.addStudent(s);

			return new ResponseEntity<>(Collections.singletonMap("msg","Student added successfully"), HttpStatus.OK);

			
		} catch (InvalidStudentException e) {

			throw  new InvalidStudentException(e.getMessage()+" add student error ");

		}
		
	}
	
	@PutMapping("/update/{studId}")
	public ResponseEntity<Object> updateStudent(@PathVariable Integer studId,@Valid @RequestBody StudentDTO s,BindingResult bindingResult)
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
			return new ResponseEntity<>(Collections.singletonMap("msg","Student updated successfully"), HttpStatus.OK);
			
		} catch (InvalidStudentException e) {
			throw  new InvalidStudentException(e.getMessage()+"Stud Id error");
		}
		
	}
	
	@DeleteMapping("/delete/{studId}")
	public ResponseEntity<Object> deleteStudent(@PathVariable Integer studId)
	{
		try {
			studentService.deleteStudentByStudentId(studId);
			return new ResponseEntity<>(Collections.singletonMap("msg","Student deleted successfully"), HttpStatus.OK);
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
	
	@GetMapping("/getEmail/{email}")
	public ResponseEntity<Object> findByStudentEmail(@PathVariable String email)
	{
		try {
			return new ResponseEntity<>(studentService.findByStudentEmail(email), HttpStatus.OK);
			
		} catch (InvalidStudentException e) {
			throw  new InvalidStudentException(e.getMessage()+"Stud Id error");
		}
		
	}
	
	@GetMapping("/getStudentsByCourse/{course_id}")
	public ResponseEntity<Object> findStudentsByCourse(@PathVariable Integer course_id)
	{
		try {
			return new ResponseEntity<>(courseService.getAllStudentsByCourse(course_id), HttpStatus.OK);
		}
		catch (InvalidCourseException e) {
			throw new InvalidCourseException(e.getMessage()+" Course Id error");
		}
		
	}
	@PostMapping("/enrollCourse")
	public ResponseEntity<Object> addStudentCourseEntry(@RequestBody Student_Course_MappingDTO student_Course_MappingDTO){
		courseService.addStudentCourse(student_Course_MappingDTO);
		return new ResponseEntity<>(Collections.singletonMap("msg","Course student entry has been successfully done"), HttpStatus.OK);
	}
	

	@PostMapping("/addTest")
	public ResponseEntity<Object> addStudentTestEntry(@RequestBody Student_Test_MappingDTO student_Test_MappingDTO){
		testService.addStudentTest(student_Test_MappingDTO);
		return new ResponseEntity<>(Collections.singletonMap("msg","Test student entry added successfully"), HttpStatus.OK);
	}
	
	@GetMapping("/courseAttendence/{stud_id}/{course_id}")
	public ResponseEntity<Object> getCourseAttendence(@PathVariable int stud_id,@PathVariable int course_id){
		return new ResponseEntity<>(courseService.getCourseAttendence(stud_id,course_id)
,HttpStatus.OK);
	}
	
	
	
}


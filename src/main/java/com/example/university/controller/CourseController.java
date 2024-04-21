package com.example.university.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.university.dto.CourseDTO;
import com.example.university.entity.DatabaseFile;
import com.example.university.exception.InvalidCourseException;
import com.example.university.exception.InvalidDataValidationException;
import com.example.university.service.ICourseService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/course")
@CrossOrigin("http://localhost:4200")
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
			return new ResponseEntity<>(Collections.singletonMap("msg","Course added successfully"), HttpStatus.OK);
			
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
			return new ResponseEntity<>(Collections.singletonMap("msg","Course updated successfully"), HttpStatus.OK);
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
			return new ResponseEntity<>(Collections.singletonMap("msg","Course deleted successfully"), HttpStatus.OK);
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
	
	@GetMapping("/getCoursesByTeacher/{teacher_id}")
	public ResponseEntity<Object> findCoursesByTeacher(@PathVariable Integer teacher_id)
	{
		try {
			return new ResponseEntity<>(courseService.getAllCoursesByTeacher(teacher_id), HttpStatus.OK);
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
			return new ResponseEntity<>(Collections.singletonMap("msg","Course lecture count incremented successfully"), HttpStatus.OK);
		}
		catch (InvalidCourseException e) {
			throw new InvalidCourseException(e.getMessage()+" Course Id error");
		}
		
		
	}
	
	
	 

	    @PostMapping("/uploadFile")
	    public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file) {
	    	DatabaseFile fileName = courseService.storeFile(file);

	        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
	                .path("/course/downloadFile/")
	                .path(fileName.getFileName())
	                .toUriString();

	      return new ResponseEntity<>(Collections.singletonMap("msg",fileDownloadUri), HttpStatus.OK);
	    }

	    @GetMapping("/downloadFile/{fileName:.+}")
	    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
	        // Load file as Resource
	        DatabaseFile databaseFile = courseService.getFile(fileName);

	        return ResponseEntity.ok()
	                .contentType(MediaType.parseMediaType(databaseFile.getFileType()))
	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + databaseFile.getFileName() + "\"")
	                .body(new ByteArrayResource(databaseFile.getData()));
	    }
	
	
}

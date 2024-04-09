package com.example.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.university.dto.CourseDTO;
import com.example.university.dto.Student_Course_MappingDTO;
import com.example.university.entity.StudentCourseKey;
import com.example.university.service.ICourseService;

@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	ICourseService courseService;
	
	@GetMapping("/get/all")
	public ResponseEntity<Object> listAllCourses() {
		return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Object> addCourse(@RequestBody CourseDTO c)
	{
		courseService.addCourse(c);
		return new ResponseEntity<>("Course added Successfully", HttpStatus.OK);
	}
	
	@PutMapping("/update/{user_id}")
	public ResponseEntity<Object> updateCourse(@PathVariable Integer user_id,@RequestBody CourseDTO c)
	{
		courseService.updateCourse(user_id, c);
		return new ResponseEntity<>("Course updated Successfully", HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{course_id}")
	public ResponseEntity<Object> deleteCourse(@PathVariable Integer course_id)
	{
		courseService.deleteCourseById(course_id);
		return new ResponseEntity<>("Course deleted Successfully", HttpStatus.OK);
	}
	
	@GetMapping("/get/{course_id}")
	public ResponseEntity<Object> findByCourseId(@PathVariable Integer course_id)
	{
		return new ResponseEntity<>(courseService.findByCourseId(course_id), HttpStatus.OK);
	}
	
	@PutMapping("/incrementLectureCount/{course_id}")
	public ResponseEntity<Object> incrementLectureCount(@PathVariable Integer course_id)
	{
		courseService.incrementLectureCount(course_id);
		return new ResponseEntity<>("Course Lecture Count incremented Successfully", HttpStatus.OK);
	}
	
	
	
	
	
	
	
}

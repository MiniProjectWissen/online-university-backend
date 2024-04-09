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


import com.example.university.dto.StudentDTO;
import com.example.university.dto.Student_Course_MappingDTO;
import com.example.university.entity.StudentCourseKey;
import com.example.university.service.ICourseService;
import com.example.university.service.IStudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private IStudentService studentService;
	
	@Autowired
	private ICourseService courseService;
	
	@GetMapping("/get/all")
	public ResponseEntity<Object> listAllCourses() {
		return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Object> addCourse(@RequestBody StudentDTO s)
	{
		studentService.addStudent(s);
		return new ResponseEntity<>("Student added Successfully", HttpStatus.OK);
	}
	
	@PutMapping("/update/{studId}")
	public ResponseEntity<Object> updateCourse(@PathVariable Integer studId,@RequestBody StudentDTO s)
	{
		studentService.updateStudentByStudentId(studId,s);
		return new ResponseEntity<>("Student updated Successfully", HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{course_id}")
	public ResponseEntity<Object> deleteCourse(@PathVariable Integer studId)
	{
		studentService.deleteStudentByStudentId(studId);
		return new ResponseEntity<>("Student deleted Successfully", HttpStatus.OK);
	}
	
	@GetMapping("/get/{studId}")
	public ResponseEntity<Object> findByStudentId(@PathVariable Integer studId)
	{
		return new ResponseEntity<>(studentService.findByStudentId(studId), HttpStatus.OK);
	}
	
	
	@PostMapping("/getCourse")
	public ResponseEntity<Object> addStudentCourseEntry(@RequestBody Student_Course_MappingDTO student_Course_MappingDTO){
		courseService.addStudentCourse(student_Course_MappingDTO);
		return new ResponseEntity<>("Courese Student entry has been successfully done",HttpStatus.OK);
	}
	
	@GetMapping("/courseAttendence/{studentCourseId}")
	public ResponseEntity<Object> getCourseAttendence(@PathVariable StudentCourseKey studentCourseId){
		courseService.getCourseAttendence(studentCourseId);
		return new ResponseEntity<>("Course Attendence found",HttpStatus.OK);
	}
	
}


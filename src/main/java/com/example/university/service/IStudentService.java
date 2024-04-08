package com.example.university.service;



import com.example.university.dto.StudentDTO;
import com.example.university.entity.Student;

public interface IStudentService {
	
	public Student addStudent(StudentDTO studentDto);

	public void deleteStudent(String studentUSN);

	public StudentDTO findByUserId(Integer userId);

	public Student updateStudent(Integer userId, StudentDTO studentDto);

}

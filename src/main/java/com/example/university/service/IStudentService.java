package com.example.university.service;



import java.util.ArrayList;

import com.example.university.dto.StudentDTO;
import com.example.university.entity.Student;

public interface IStudentService {
	
	public Student addStudent(StudentDTO studentDto);

	

	public StudentDTO findByStudentId(Integer userId);
	
	public ArrayList<StudentDTO> getAllStudents();

	public Student updateStudent(Integer userId, StudentDTO studentDto);

	



	void deleteStudent(Integer stud_id);

}

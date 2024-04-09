package com.example.university.service;



import java.util.ArrayList;

import com.example.university.dto.StudentDTO;
import com.example.university.entity.Student;

public interface IStudentService {
	
	public Student addStudent(StudentDTO studentDto);

	

	public StudentDTO findByStudentId(Integer userId);
	
	public ArrayList<StudentDTO> getAllStudents();

	public Student updateStudentByStudentId(Integer userId, StudentDTO studentDto);

	



	void deleteStudentByStudentId(Integer stud_id);

}

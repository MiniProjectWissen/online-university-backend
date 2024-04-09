package com.example.university.service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.example.university.dto.StudentDTO;
import com.example.university.entity.Student;

@Service
public interface IStudentService {
	
	public Student addStudent(StudentDTO studentDto);

	

	public StudentDTO findByStudentId(Integer userId);
	
	public List<StudentDTO> getAllStudents();

	public Student updateStudentByStudentId(Integer userId, StudentDTO studentDto);

	



	void deleteStudentByStudentId(Integer stud_id);

}

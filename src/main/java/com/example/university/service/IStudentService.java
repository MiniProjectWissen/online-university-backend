package com.example.university.service;



import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.university.dto.CourseDTO;
import com.example.university.dto.StudentDTO;
import com.example.university.dto.TestDTO;
import com.example.university.entity.Course;
import com.example.university.entity.Student;

@Service
public interface IStudentService {
	
	public Student addStudent(StudentDTO studentDto);

	public StudentDTO findByStudentId(Integer userId);
	public StudentDTO findByStudentEmail(String email);

	
	public List<StudentDTO> getAllStudents(); 
	public List<CourseDTO> getAllEnrolledCourses(Integer stud_id);

	public Student updateStudentByStudentId(Integer userId, StudentDTO studentDto);


	void deleteStudentByStudentId(Integer stud_id);
	
	public List<TestDTO> getTestsByStudId(Integer stud_id);
	
	public int getMarksByStudIdTestId(Integer stud_id,Integer test_id);
	
	public void updateMarksByStudIdTestId(Integer stud_id,Integer test_id,Integer marks);
}

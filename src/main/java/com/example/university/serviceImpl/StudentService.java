package com.example.university.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.university.dao.IStudentDao;
import com.example.university.dto.StudentDTO;
import com.example.university.entity.Student;
import com.example.university.service.IStudentService;

public class StudentService implements IStudentService {
	
	@Autowired
	private IStudentDao studentDao;

	@Override
	public Student addStudent(StudentDTO studentDto) {
		
		return null;
	}

	@Override
	public void deleteStudent(String studentUSN) {
		// TODO Auto-generated method stub

	}

	@Override
	public StudentDTO findByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student updateStudent(Integer userId, StudentDTO studentDto) {
		// TODO Auto-generated method stub
		return null;
	}

}

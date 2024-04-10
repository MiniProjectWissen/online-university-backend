package com.example.university.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.university.dto.Student_Test_MappingDTO;
import com.example.university.dto.TestDTO;
import com.example.university.entity.Student_Test_Mapping;
import com.example.university.entity.Test;

@Service
public interface ITestService {

	public Test createTest(TestDTO testDTO);
	public Test updateTest(Integer user_id,TestDTO testDTO);
	public void deleteTest(Integer test_id);
	public TestDTO findByTestId(Integer test_id);
	public List<TestDTO> getAllTests();
	
	public Student_Test_Mapping addStudentTest(Student_Test_MappingDTO student_Test_MappingDTO);

}

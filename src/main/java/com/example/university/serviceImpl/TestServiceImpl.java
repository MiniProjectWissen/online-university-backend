package com.example.university.serviceImpl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.university.dao.ICourseDao;
import com.example.university.dao.ITestDao;
import com.example.university.dao.Student_Test_MappingDao;
import com.example.university.dao.IStudentDao;
import com.example.university.dto.Student_Test_MappingDTO;
import com.example.university.dto.TestDTO;
import com.example.university.entity.Course;
import com.example.university.entity.Student;
import com.example.university.entity.Student_Test_Mapping;
import com.example.university.entity.Test;
import com.example.university.exception.InvalidTestException;
import com.example.university.service.ITestService;

import jakarta.transaction.Transactional;

@Service
public class TestServiceImpl implements ITestService{

	@Autowired
	ITestDao testDao;
	
	@Autowired
	ICourseDao courseDao;
	
	@Autowired
	IStudentDao studentDao;
	
	@Autowired
	Student_Test_MappingDao student_Test_MappingDao;
	
	public Test createTest(TestDTO testDTO)
	{
		Test test=new Test();
		test.setStart_time(testDTO.getStart_time());
		test.setEnd_time(testDTO.getEnd_time());
		test.setTest_content(testDTO.getTest_content());
		test.setTotal_marks(testDTO.getTotal_marks());
		Course c=courseDao.findById(testDTO.getCourse_id()).get();
		test.setCourse(c);
		return testDao.save(test);
	}
	
	public Test updateTest(Integer test_id,TestDTO testDTO)
	{
		if (testDao.existsById(test_id))
		{
			Test test =testDao.findById(test_id).get();
			Course c=courseDao.findById(testDTO.getCourse_id()).get();
			test.setCourse(c);
			test.setStart_time(testDTO.getStart_time());
			test.setEnd_time(testDTO.getEnd_time());
			test.setTest_content(testDTO.getTest_content());
			test.setTotal_marks(testDTO.getTotal_marks());
			
			return testDao.save(test);	
		}else {
			throw new InvalidTestException();
		}
	}
	
	public void deleteTest(Integer test_id)
	{
		if (testDao.existsById(test_id))
		{
			testDao.deleteById(test_id);
		}else {
			throw new InvalidTestException();
		}
	}
	
	public TestDTO findByTestId(Integer test_id)
	{
		if (testDao.existsById(test_id))
		{
			return testDao.findByTestId(test_id);
		}else {
			throw new InvalidTestException();
		}
	}
	
	public List<TestDTO> getAllTests()
	{
		return testDao.findAllTests();
	}
	
	@Transactional
	public Student_Test_Mapping addStudentTest(Student_Test_MappingDTO student_Test_MappingDTO)
	{
		Student s = studentDao.findById(student_Test_MappingDTO.getId().getStud_id()).get();
		Test t = testDao.findById(student_Test_MappingDTO.getId().getTest_id()).get();
		
		Set<Test> my_test_list=s.getTests();
		my_test_list.add(t);
		s.setTests(my_test_list);
		
		Set<Student> student_test_list=t.getStudents();
		student_test_list.add(s);
		t.setStudents(student_test_list);
		
		if(!student_Test_MappingDao.existsById(student_Test_MappingDTO.getId())) {
			
			Student_Test_Mapping stm = new Student_Test_Mapping();
			stm.setId(student_Test_MappingDTO.getId());
			stm.setMarks(0);
			return student_Test_MappingDao.save(stm);
		}
		return null;
	}
	
	public List<TestDTO> getTestsByCourse(Integer course_id)
	{
		return testDao.findAllTestsByCourse(course_id);
	}
}

package com.example.university.serviceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.university.dao.IStudentDao;
import com.example.university.dto.StudentDTO;
import com.example.university.entity.Course;
import com.example.university.entity.Student;
import com.example.university.service.IStudentService;

public class StudentServiceImpl implements IStudentService {
	
	@Autowired
	private IStudentDao studentDao;

	@Override
	public Student addStudent(StudentDTO studentDto) {
		Student student = new Student();
		student.setAddress(studentDto.getAddress());
		student.setDob(studentDto.getDob());
		student.setEmail(studentDto.getEmail());
		student.setFirst_name(studentDto.getFirst_name());
		student.setLast_name(studentDto.getLast_name());
		student.setGender(studentDto.getGender());
		student.setPassword(studentDto.getPassword());
		student.setCourses(new ArrayList<Course>());
		student.setPhone_number(null);
		student.setRoll_no(studentDto.getRoll_no());
		student.setStandard(studentDto.getStandard());
		
		return null;
	}

	@Override
	public void deleteStudent(Integer stud_id) {
		
		if(studentDao.existsById(stud_id)) {
			studentDao.deleteById(stud_id);
		}
		else {
			
		}
	}

	

	@Override
	public Student updateStudent(Integer userId, StudentDTO studentDto) {
		
		return null;
	}

	@Override
	public StudentDTO findByStudentId(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<StudentDTO> getAllStudents() {
		// TODO Auto-generated method stub
		return null;
	}

}

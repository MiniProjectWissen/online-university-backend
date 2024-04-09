package com.example.university.serviceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.university.dao.IStudentDao;
import com.example.university.dto.StudentDTO;
import com.example.university.entity.Course;
import com.example.university.entity.Student;
import com.example.university.exception.InvalidCourseException;
import com.example.university.exception.InvalidStudentException;
import com.example.university.service.IStudentService;


@Service
public class StudentServiceImpl implements IStudentService {
	
	@Autowired
	private IStudentDao studentDao;

	@Override
	public Student addStudent(StudentDTO studentDto) {
		
		//if(!studentDao.findByEmail(studentDto.getEmail())) {
		
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
		
		return studentDao.save(student);
		//}
		//return null;
	}

	@Override
	public void deleteStudentByStudentId(Integer studId) {
		
		if(studentDao.existsById(studId)) {
			studentDao.deleteById(studId);
		}
		else {
			throw new InvalidStudentException();
		}
	}

	

	@Override
	public Student updateStudentByStudentId(Integer studId, StudentDTO studentDto) {
		if(studentDao.existsById(studId)) {
			Student student= studentDao.findById(studId).get();
			
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
			
			return studentDao.save(student);
			
		}
		else {
			throw new InvalidStudentException();
		}
		
	}

	@Override
	public StudentDTO findByStudentId(Integer studId) {
		if(studentDao.existsById(studId)) {
			return studentDao.findByStudentId(studId);
		}
		else {
			throw new InvalidStudentException();
		}
	}

	@Override
	public ArrayList<StudentDTO> getAllStudents() {
		return studentDao.findAllStudents();
	}

}

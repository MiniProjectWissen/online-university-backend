package com.example.university.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.university.dao.ICourseDao;
import com.example.university.dao.IStudentDao;
import com.example.university.dao.Student_Course_MappingDao;
import com.example.university.dto.CourseDTO;
import com.example.university.dto.StudentDTO;
import com.example.university.dto.Student_Course_MappingDTO;
import com.example.university.entity.Course;
import com.example.university.entity.Student;
import com.example.university.entity.Student_Course_Mapping;
import com.example.university.exception.InvalidCourseException;
import com.example.university.exception.InvalidStudentException;
import com.example.university.service.IStudentService;


@Service
public class StudentServiceImpl implements IStudentService {
	
	@Autowired
	private IStudentDao studentDao;
	
	@Autowired
	private ICourseDao courseDao;
	
	@Autowired
	private Student_Course_MappingDao scmDao;

	@Override
	public Student addStudent(StudentDTO studentDto) {

//		if(!studentDao.existsByEmail(studentDto.getEmail())) {
			Student student = new Student();
			student.setAddress(studentDto.getAddress());
			student.setDob(studentDto.getDob());
			student.setEmail(studentDto.getEmail());
			student.setFirst_name(studentDto.getFirst_name());
			student.setLast_name(studentDto.getLast_name());
			student.setGender(studentDto.getGender());
			student.setPassword(studentDto.getPassword());
//			student.setCourses(new List<Course>());
			student.setPhone_number(studentDto.getPhone_number());
			student.setRoll_no(studentDto.getRoll_no());
			student.setStandard(studentDto.getStandard());
			
			return studentDao.save(student);
//		}
//		return null;
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
//			student.setCourses(new List<Course>());
			student.setPhone_number(studentDto.getPhone_number());
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
	public StudentDTO findByStudentEmail(String email) {
		if(studentDao.existsByEmail(email)) {
			return studentDao.findByEmail(email);
		}
		else {
			throw new InvalidStudentException();
		}
	}
	@Override
	public List<StudentDTO> getAllStudents() {
		return studentDao.findAllStudents();
	}

	@Override
	public List<CourseDTO> getAllEnrolledCourses(Integer stud_id) {
		List<Student_Course_Mapping> list = scmDao.findAll();
		List<Integer> l1 = new ArrayList<Integer>();
		for(Student_Course_Mapping scm: list ) {
			if(scm.getId().getStud_id()==stud_id)
				l1.add(scm.getId().getCourse_id());
		}
		System.out.println(list);
		return courseDao.findAllCoursesByStudent(l1);
	}
}

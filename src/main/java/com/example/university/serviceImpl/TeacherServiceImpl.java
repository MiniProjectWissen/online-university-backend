package com.example.university.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.university.dao.ITeacherDao;
import com.example.university.dto.TeacherDTO;
import com.example.university.entity.Teacher;
import com.example.university.exception.InvalidStudentException;
import com.example.university.exception.InvalidTeacherException;
import com.example.university.service.ITeacherService;

@Service
public class TeacherServiceImpl implements ITeacherService {
	
	@Autowired
	private ITeacherDao teacherDao;
	
	
	
	
	public Teacher createTeacher(TeacherDTO teacherDto) {
		if(!teacherDao.findByEmail(teacherDto.getEmail())) {
			Teacher teacher = new Teacher();
			
			teacher.setTeacher_id(teacherDto.getTeacher_id());
			teacher.setFirst_name(teacherDto.getFirst_name());
			teacher.setLast_name(teacherDto.getLast_name());
			teacher.setAddress(teacherDto.getAddress());
			teacher.setDob(teacherDto.getDob());
			teacher.setEmail(teacherDto.getEmail());
			teacher.setPassword(teacherDto.getPassword());
			teacher.setGender(teacherDto.getGender());
			teacher.setPhone_number(teacher.getPhone_number());
			teacher.setPosition(teacherDto.getPosition());
			teacher.setIsAdmin(0);
		
			return teacherDao.save(teacher);
		}
		return null;
	}
	
	public TeacherDTO getTeacher(int teacherId) {
		if(teacherDao.existsById(teacherId)) {
			return teacherDao.findTeacher(teacherId);
		}
		else {
			throw new InvalidTeacherException();
		}	
	}
	
	public List<TeacherDTO> getAllTeachers(){
		return teacherDao.findAllTeacher();
	}
	
	public Teacher updateTeacher(int teacherId , TeacherDTO teacherDto) {
		if(teacherDao.existsById(teacherId)) {
			Teacher teacher = teacherDao.findById(teacherId).get();
			teacher.setFirst_name(teacherDto.getFirst_name());
			teacher.setLast_name(teacherDto.getLast_name());
			teacher.setAddress(teacherDto.getAddress());
			teacher.setDob(teacherDto.getDob());
			teacher.setEmail(teacherDto.getEmail());
			teacher.setPassword(teacherDto.getPassword());
			teacher.setGender(teacherDto.getGender());
			teacher.setPhone_number(teacher.getPhone_number());
			teacher.setPosition(teacherDto.getPosition());
			teacher.setIsAdmin(0);
			
//			teacher.setCourses(null);
			return teacherDao.save(teacher);
		}
		else {
			throw new InvalidTeacherException();
		}
	}
	
	public void deleteTeacher(int teacherId) {
		if(teacherDao.existsById(teacherId)) {
			teacherDao.deleteById(teacherId);
		}else {
			throw new InvalidTeacherException();
		}
	}

}

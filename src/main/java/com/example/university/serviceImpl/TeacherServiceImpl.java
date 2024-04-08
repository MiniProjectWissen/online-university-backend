package com.example.university.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.university.dao.ITeacherDao;
import com.example.university.dto.TeacherDTO;
import com.example.university.entity.Teacher;
import com.example.university.service.ITeacherService;

@Service
public class TeacherServiceImpl implements ITeacherService {
	
	@Autowired
	private ITeacherDao teacherDao;
	
	
	public Teacher createTeacher(TeacherDTO teacherDto) {
		if(!teacherDao.existsById(teacherDto.getTeacher_id())) {
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
//			return teacherDao.findTeacher(teacherId);
		}
		return null;
		
		
	}
	
//	public List<TeacherDTO> getAllTeachers(){
//		return teacherDao.findAllTeacher();
//	}
//	
	public TeacherDTO updateTeacher(int teacherId , TeacherDTO teacherDto) {
		return null;
	}
	
	public void deleteTeacher(int teacherId) {
		
	}

	

}

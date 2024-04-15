package com.example.university.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.university.dto.TeacherDTO;
import com.example.university.entity.Teacher;

@Service
public interface ITeacherService {

	public Teacher createTeacher(TeacherDTO teacherDto);
	public TeacherDTO getTeacher(int teacherId);
	public List<TeacherDTO> getAllTeachers();
	public Teacher updateTeacher(int teacherId , TeacherDTO teacherDto);
	public void deleteTeacher(int teacherId);
	
}

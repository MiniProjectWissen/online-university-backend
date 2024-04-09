package com.example.university.service;


import java.util.List;


import org.springframework.stereotype.Service;

import com.example.university.dto.CourseDTO;

import com.example.university.entity.Course;

@Service
public interface ICourseService {

	public Course addCourse(CourseDTO courseDTO);
	public Course updateCourse(Integer userId,CourseDTO courseDTO);
	public void deleteCourseById(Integer courseId);
	public CourseDTO findByCourseId(Integer courseId);
	public void incrementLectureCount(Integer courseId);

	public List<CourseDTO> getAllCourses();

}

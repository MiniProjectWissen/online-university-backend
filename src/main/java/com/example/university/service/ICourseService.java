package com.example.university.service;


import java.util.List;


import org.springframework.stereotype.Service;

import com.example.university.dto.CourseDTO;
import com.example.university.dto.Student_Course_MappingDTO;
import com.example.university.entity.Course;
import com.example.university.entity.StudentCourseKey;
import com.example.university.entity.Student_Course_Mapping;

@Service
public interface ICourseService {

	public Course addCourse(CourseDTO courseDTO);
	public Course updateCourse(Integer userId,CourseDTO courseDTO);
	public void deleteCourseById(Integer courseId);
	public CourseDTO findByCourseId(Integer courseId);
	public void incrementLectureCount(Integer courseId);

	public List<CourseDTO> getAllCourses();
	
	public Student_Course_Mapping addStudentCourse(Student_Course_MappingDTO student_Course_MappingDTO);
	public void incrementStudentAttendenceCount(int stud_id,int course_id);
	public double getCourseAttendence(int stud_id,int course_id);
	

}

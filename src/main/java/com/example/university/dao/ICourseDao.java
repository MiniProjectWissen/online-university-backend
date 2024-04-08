package com.example.university.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.university.dto.CourseDTO;
import com.example.university.entity.Course;

public interface ICourseDao extends JpaRepository<Course, Integer> {

	@Query("select new com.example.university.dto.CourseDTO(s.forum_id, s.title, s.description, s.start_date,s.end_date,s.sch_days,s.syllabus,s.join_time,s.end_time,s.lectures_taken ,s.Teacher.teacher_id ) from Course s where s.course_id=:courseId")
	CourseDTO findByCourseId(@Param("courseId") Integer courseId);
}

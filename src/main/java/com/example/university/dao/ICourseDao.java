package com.example.university.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.example.university.dto.CourseDTO;
import com.example.university.entity.Course;

@Repository
public interface ICourseDao extends JpaRepository<Course, Integer> {


	@Query("SELECT new com.example.university.dto.CourseDTO(c.course_id,c.forum_id,c.title,c.description,c.start_date,c.end_date,c.sch_days,c.syllabus,c.join_time,c.end_time,c.lectures_taken,c.teacher.teacher_id) FROM Course c WHERE c.course_id = :courseId")
	CourseDTO findByCourseId(@Param("courseId") Integer courseId);
	
	@Query(value="select new com.example.university.dto.CourseDTO(c.course_id,c.forum_id,c.title,c.description,c.start_date,c.end_date,c.sch_days,c.syllabus,c.join_time,c.end_time,c.lectures_taken,c.teacher.teacher_id) from Course c")
	List<CourseDTO> findAllCourses();
	
	@Query(value="select new com.example.university.dto.CourseDTO(c.course_id,c.forum_id,c.title,c.description,c.start_date,c.end_date,c.sch_days,c.syllabus,c.join_time,c.end_time,c.lectures_taken,c.teacher.teacher_id) from Course c where c.course_id in :list")
	List<CourseDTO> findAllCoursesByStudent(@Param("list") List<Integer> list);
	
	@Query(value="select new com.example.university.dto.CourseDTO(c.course_id,c.forum_id,c.title,c.description,c.start_date,c.end_date,c.sch_days,c.syllabus,c.join_time,c.end_time,c.lectures_taken,c.teacher.teacher_id) from Course c where c.teacher.teacher_id = :teacherID")
	List<CourseDTO> findAllCoursesByTeacher(@Param("teacherID") int teacherID);

}

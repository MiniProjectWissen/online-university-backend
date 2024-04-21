package com.example.university.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.university.dto.Student_Course_MappingDTO;
import com.example.university.entity.StudentCourseKey;
import com.example.university.entity.Student_Course_Mapping;
//import com.example.university.entity.Teacher;

@Repository
public interface Student_Course_MappingDao extends JpaRepository<Student_Course_Mapping, StudentCourseKey> {

//	@Query("select course_id from Student_Course_Mapping where stud_id = :stud_id")
//	List<Integer> myQuery(@Param("stud_id") int stud_id);
	
//	@Query("select new com.example.university.dto.Student_Course_MappingDTO(scm.id,scm.attendance_lecture_count) from Student_Course_Mapping scm where scm.stud_id = : stud_id" )
//	List<Student_Course_MappingDTO> findCourseList(Integer stud_id);
}

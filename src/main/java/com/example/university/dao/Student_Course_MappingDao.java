package com.example.university.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.university.entity.StudentCourseKey;
import com.example.university.entity.Student_Course_Mapping;

@Repository
public interface Student_Course_MappingDao extends JpaRepository<Student_Course_Mapping, StudentCourseKey> {
	
}

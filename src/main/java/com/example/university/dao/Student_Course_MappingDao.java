package com.example.university.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.university.entity.StudentCourseKey;
import com.example.university.entity.Student_Course_Mapping;
//import com.example.university.entity.Teacher;

@Repository
public interface Student_Course_MappingDao extends JpaRepository<Student_Course_Mapping, StudentCourseKey> {

	
}

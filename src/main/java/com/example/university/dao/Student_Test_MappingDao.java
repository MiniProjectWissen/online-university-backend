package com.example.university.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.university.entity.StudentTestKey;
import com.example.university.entity.Student_Test_Mapping;

public interface Student_Test_MappingDao extends JpaRepository<Student_Test_Mapping, StudentTestKey>{

}

package com.example.university.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.university.entity.StudentTestKey;
import com.example.university.entity.Student_Test_Mapping;

import feign.Param;

public interface Student_Test_MappingDao extends JpaRepository<Student_Test_Mapping, StudentTestKey>{
	
	@Query("SELECT stm.marks FROM Student_Test_Mapping stm WHERE stm.id.stud_id = :stud_id AND stm.id.test_id = :test_id")
	int findByStudIdTestId(@Param("stud_id") int stud_id, @Param("test_id") int test_id);

	
}

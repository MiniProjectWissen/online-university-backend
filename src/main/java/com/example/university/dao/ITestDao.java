package com.example.university.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.university.dto.TestDTO;
import com.example.university.entity.Test;

@Repository
public interface ITestDao extends JpaRepository<Test, Integer> {

	@Query("SELECT new com.example.university.dto.TestDTO(t.test_id,t.start_time,t.end_time,t.total_marks,t.test_content,t.course.course_id) FROM Test t WHERE t.test_id = :testId")
	TestDTO findByTestId(@Param("testId") Integer testId);
	
	@Query(value="select new com.example.university.dto.TestDTO(t.test_id,t.start_time,t.end_time,t.total_marks,t.test_content,t.course.course_id) from Test t")
	List<TestDTO> findAllTests();

}

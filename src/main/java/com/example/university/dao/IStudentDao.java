package com.example.university.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.university.dto.CourseDTO;
import com.example.university.dto.StudentDTO;
import com.example.university.entity.Student;

@Repository
public interface IStudentDao extends JpaRepository<Student, Integer>{
	@Query("SELECT new com.example.university.dto.StudentDTO(s.stud_id,s.first_name,s.last_name,s.email,s.password,s.address,s.phone_number,s.gender,s.dob,s.roll_no,s.standard) FROM Student s WHERE s.stud_id = :studId")
	StudentDTO findByStudentId(@Param("studId") Integer studId);
	
	@Query("SELECT new com.example.university.dto.StudentDTO(s.stud_id,s.first_name,s.last_name,s.email,s.password,s.address,s.phone_number,s.gender,s.dob,s.roll_no,s.standard) FROM Student s")
	ArrayList<StudentDTO> findAllStudents();


	boolean existsByEmail(String email);
	
	@Query("SELECT new com.example.university.dto.StudentDTO(s.stud_id,s.first_name,s.last_name,s.email,s.password,s.address,s.phone_number,s.gender,s.dob,s.roll_no,s.standard) FROM Student s WHERE s.email = :email")
	StudentDTO findByEmail(@Param("email") String email);
	
	@Query(value="select new com.example.university.dto.StudentDTO(s.stud_id,s.first_name,s.last_name,s.email,s.password,s.address,s.phone_number,s.gender,s.dob,s.roll_no,s.standard) from Student s where s.stud_id in :list")
	List<StudentDTO> findAllStudentByCourse(@Param("list") List<Integer> list);
}

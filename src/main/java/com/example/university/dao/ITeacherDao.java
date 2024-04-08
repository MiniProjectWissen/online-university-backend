package com.example.university.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.university.dto.TeacherDTO;
import com.example.university.entity.Teacher;

@Repository
public interface ITeacherDao extends JpaRepository<Teacher, Integer> {

//	@Query("select new com.example.university.dto.TeacherDTO(t.teacher_id,t.first_name,t.last_name,t.email,t.password,t.address,t.phone_number,t.gender,t.dob,t.position,t.is_admin) from Teacher t where t.teacher_id like :teacherId ")
//	TeacherDTO findTeacher(@Param("teacherId") int teacherId);
	
//	@Query("select new com.example.university.dto.TeacherDTO(t.teacher_id,t.first_name,t.last_name,t.email,t.password,t.address,t.phone_number,t.gender,t.dob,t.position,t.is_admin) from Teacher t  ")
//	List<TeacherDTO> findAllTeacher();
}

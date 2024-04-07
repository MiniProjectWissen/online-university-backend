package com.example.university.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.university.entity.Teacher;

public interface ITeacherDao extends JpaRepository<Teacher, Integer> {

}

package com.example.university.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.university.entity.Course;

public interface ICourseDao extends JpaRepository<Course, Integer> {

}

package com.example.university.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student_Course_Mapping {
	@Id
	
	private int stud_id;
	@Id
	
	private int course_id;
	private int attendance_lecture_count;
	
}

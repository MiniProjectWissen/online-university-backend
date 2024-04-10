package com.example.university.entity;

import org.springframework.beans.factory.annotation.Value;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
	
	@EmbeddedId
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private StudentCourseKey id;
	@Column(nullable = true)
//	@Value("${attendance_lecture_count:0}")
	private int attendance_lecture_count;
	
	
	public Student_Course_Mapping() {
		this.attendance_lecture_count = 0;

	}
	
	public Student_Course_Mapping(StudentCourseKey id, int attendance_lecture_count) {
		super();
		this.id = id;
		this.attendance_lecture_count = 0;
	}

	public StudentCourseKey getId() {
		return id;
	}

	public void setId(StudentCourseKey id) {
		this.id = id;
	}

	
	public int getAttendance_lecture_count() {
		return attendance_lecture_count;
	}
	public void setAttendance_lecture_count(int attendance_lecture_count) {
		this.attendance_lecture_count = attendance_lecture_count;
	}
	
}

package com.example.university.entity;

import java.sql.Blob;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Data
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int course_id;
	
	private int forum_id;
	private String title;
	private String description;
	private Date start_date;
	private Date end_date;
	private String sch_days;
	private Blob syllabus;
	private Time join_time;
	private Time end_time;
	private int lectures_taken;
	
	@ManyToMany(targetEntity = Student.class, cascade = CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinTable(name = "Student_Course_Mapping", joinColumns = @JoinColumn(name = "course_id"), inverseJoinColumns = @JoinColumn(name = "stud_id"))
	private ArrayList<Student> students;
	
	@ManyToOne(targetEntity = Teacher.class,cascade = CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "teacher_id")
	private Teacher teacher;
	
	

}

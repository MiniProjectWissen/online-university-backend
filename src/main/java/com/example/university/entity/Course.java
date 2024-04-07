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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;


@Entity
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
	
	@ManyToMany(mappedBy = "courses_list", targetEntity = Student.class, cascade = CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private ArrayList<Student> students_list;
	
	@ManyToOne(targetEntity = Teacher.class,cascade = CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "teacher_id")
	private Teacher teacher;
	
	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	

	public int getForum_id() {
		return forum_id;
	}

	public void setForum_id(int forum_id) {
		this.forum_id = forum_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public String getSch_days() {
		return sch_days;
	}

	public void setSch_days(String sch_days) {
		this.sch_days = sch_days;
	}

	public Blob getSyllabus() {
		return syllabus;
	}

	public void setSyllabus(Blob syllabus) {
		this.syllabus = syllabus;
	}

	public Time getJoin_time() {
		return join_time;
	}

	public void setJoin_time(Time join_time) {
		this.join_time = join_time;
	}

	public Time getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Time end_time) {
		this.end_time = end_time;
	}

	public int getLectures_taken() {
		return lectures_taken;
	}

	public void setLectures_taken(int lectures_taken) {
		this.lectures_taken = lectures_taken;
	}

	public ArrayList<Student> getStudents_list() {
		return students_list;
	}

	public void setStudents_list(ArrayList<Student> students_list) {
		this.students_list = students_list;
	}

	public Course() {
		
	}

}

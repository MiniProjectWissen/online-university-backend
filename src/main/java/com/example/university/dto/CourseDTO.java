package com.example.university.dto;

import java.sql.Blob;
import java.sql.Time;
import java.util.Date;

import com.example.university.entity.Teacher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {

    private int course_id;
	private @NonNull int forum_id;
	private @NonNull String title;
	private @NonNull String description;
	private @NonNull Date start_date;
	private @NonNull Date end_date;
	private @NonNull String sch_days;
	private @NonNull Blob syllabus;
	private @NonNull Time join_time;
	private @NonNull Time end_time;
	private @NonNull int lectures_taken;
	private @NonNull int teacher_id;
	
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
	public int getTeacher_id() {
		return teacher_id;
	}
	
	
	

}

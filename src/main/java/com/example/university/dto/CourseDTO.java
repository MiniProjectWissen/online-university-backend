package com.example.university.dto;

import java.sql.Blob;
import java.sql.Time;
import java.util.Date;

import com.example.university.entity.Teacher;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {

    private int course_id;
	private  int forum_id;
	@NotBlank(message = "Title cannot be blank")
    @Size(max = 255, message = "Title must be at most 255 characters")
	private  String title;
	
	@NotBlank(message = "Description cannot be blank")
	private  String description;
	@NotNull(message = "Start date cannot be null")
    @FutureOrPresent(message = "Start date must be in the past or present")
    private  Date start_date;
	@NotNull(message = "End date cannot be null")
	@FutureOrPresent(message = "End date must be in the past or present")
	private  Date end_date;
	@NotBlank(message = "Schedule days cannot be blank")
    @Pattern(regexp = "^[01]{7}$", message = "Schedule days must be a 7-character string containing only '0' and '1' characters")
    private  String sch_days;
	private  String syllabus;
	private  Time join_time;
	private  Time end_time;
	private  int lectures_taken;
	private  int teacher_id;
	
	
	public CourseDTO(int course_id, int forum_id,
			@NotBlank(message = "Title cannot be blank") @Size(max = 255, message = "Title must be at most 255 characters") String title,
			@NotBlank(message = "Description cannot be blank") String description,
			@NotNull(message = "Start date cannot be null") @FutureOrPresent(message = "Start date must be in the past or present") Date start_date,
			@NotNull(message = "End date cannot be null") @FutureOrPresent(message = "End date must be in the past or present") Date end_date,
			@NotBlank(message = "Schedule days cannot be blank") @Pattern(regexp = "^[01]{7}$", message = "Schedule days must be a 7-character string containing only '0' and '1' characters") String sch_days,
			String syllabus, Time join_time, Time end_time, int lectures_taken, int teacher_id) {
		super();
		this.course_id = course_id;
		this.forum_id = forum_id;
		this.title = title;
		this.description = description;
		this.start_date = start_date;
		this.end_date = end_date;
		this.sch_days = sch_days;
		this.syllabus = syllabus;
		this.join_time = join_time;
		this.end_time = end_time;
		this.lectures_taken = lectures_taken;
		this.teacher_id = teacher_id;
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
	public String getSyllabus() {
		return syllabus;
	}
	public void setSyllabus(String syllabus) {
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
	public int getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}
	public void setLectures_taken(int lectures_taken) {
		this.lectures_taken = lectures_taken;
	}
}

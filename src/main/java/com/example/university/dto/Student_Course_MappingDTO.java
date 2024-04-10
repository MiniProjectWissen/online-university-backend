package com.example.university.dto;

import org.springframework.beans.factory.annotation.Value;

import com.example.university.entity.StudentCourseKey;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student_Course_MappingDTO {
	private int stud_id;
	
	public int getStud_id() {
		return stud_id;
	}

	public void setStud_id(int stud_id) {
		this.stud_id = stud_id;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public int getAttendance_lecture_count() {
		return attendance_lecture_count;
	}

	public void setAttendance_lecture_count(int attendance_lecture_count) {
		this.attendance_lecture_count = attendance_lecture_count;
	}
	

	public Student_Course_MappingDTO(int stud_id, int course_id, int attendance_lecture_count) {
		super();
		this.stud_id = stud_id;
		this.course_id = course_id;
		this.attendance_lecture_count = attendance_lecture_count;
	}


	private int course_id;
	
	private int attendance_lecture_count;
	
}

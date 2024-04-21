package com.example.university.dto;
import com.example.university.entity.StudentCourseKey;
import jakarta.persistence.EmbeddedId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Student_Course_MappingDTO {

	@EmbeddedId
	private StudentCourseKey id;

	private  int attendance_lecture_count;
	public Student_Course_MappingDTO() {
		this.attendance_lecture_count = 0;

	}
	
	public Student_Course_MappingDTO(StudentCourseKey id, int attendance_lecture_count) {
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

package com.example.university.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class StudentCourseKey implements Serializable{
	private int stud_id;
	private int course_id;
	public StudentCourseKey() {}
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
	@Override
    public boolean equals(Object o) {
		return false;
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        StudentCourseKey that = (StudentCourseKey) o;
//        return stud_id == that.stud_id && course_id == that.course_id;
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(stud_id, course_id);
//    }
	
}

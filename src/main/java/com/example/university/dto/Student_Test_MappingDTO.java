package com.example.university.dto;

import com.example.university.entity.StudentTestKey;

import jakarta.persistence.EmbeddedId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student_Test_MappingDTO {

	@EmbeddedId
	private StudentTestKey id;
	
	private int marks;

	public Student_Test_MappingDTO()
	{
		this.marks=0;
	}
	
	public Student_Test_MappingDTO(StudentTestKey id, int marks) {
		super();
		this.id = id;
		this.marks = 0;
	}

	public StudentTestKey getId() {
		return id;
	}

	public void setid(StudentTestKey id) {
		this.id= id;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	
}

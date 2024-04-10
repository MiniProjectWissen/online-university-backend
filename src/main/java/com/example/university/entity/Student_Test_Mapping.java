package com.example.university.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student_Test_Mapping {

	@EmbeddedId
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private StudentTestKey id;
	@Column(nullable = true)
	//@Column(name = "marks", columnDefinition = "int default 0")
	private int marks;

	
	public Student_Test_Mapping()
	{
		this.marks=0;
	}
	
	public Student_Test_Mapping(StudentTestKey id, int marks) {
		super();
		this.id = id;
		this.marks = marks;
	}

	public StudentTestKey getId() {
		return id;
	}

	public void setId(StudentTestKey id) {
		this.id = id;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	
}

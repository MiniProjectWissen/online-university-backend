package com.example.university.entity;

import java.sql.Date;
import java.util.ArrayList;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


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
public class Teacher {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int teacher_id;
	private String password;
	private String email;
	private String phone_number;
	private String first_name;
	private String last_name;
	private Date dob;
	private String gender;
	private String address;
	private String position;
	private int isAdmin;
	
	@OneToMany(mappedBy = "teacher",targetEntity = Course.class,cascade = CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private ArrayList<Course> courses;

	
}

package com.example.university.entity;

import java.util.ArrayList;
import java.util.Date;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

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
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stud_id;
	private String password;
	private String email;	
	private String phone_number;
	private String first_name;
	private String last_name;
	private Date dob;
	private String gender;
	private String address;
	private String roll_no;
	private int standard;
	
	@ManyToMany(targetEntity = Course.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	@OnDelete(action = OnDeleteAction.CASCADE)
	private ArrayList<Course> courses;
	
}

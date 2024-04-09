package com.example.university.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class TeacherDTO {

	private @NonNull int teacher_id;
	private @NonNull String first_name;
	private @NonNull String last_name;
	private @NonNull String email;
	private @NonNull String password;
	private @NonNull String address;
	private @NonNull String phone_number;
	private @NonNull String gender;
	private @NonNull Date dob;
	private @NonNull String position;
	private @NonNull int is_admin;
	public TeacherDTO() {}
	public TeacherDTO(@NonNull int teacher_id, @NonNull String first_name, @NonNull String last_name,
			@NonNull String email, @NonNull String password, @NonNull String address, @NonNull String phone_number,
			@NonNull String gender, @NonNull Date dob, @NonNull String position, @NonNull int is_admin) {
		super();
		this.teacher_id = teacher_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
		this.address = address;
		this.phone_number = phone_number;
		this.gender = gender;
		this.dob = dob;
		this.position = position;
		this.is_admin = is_admin;
	}

	public int getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getIs_admin() {
		return is_admin;
	}
	public void setIs_admin(int is_admin) {
		this.is_admin = is_admin;
	}
	
}

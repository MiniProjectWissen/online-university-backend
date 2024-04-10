package com.example.university.dto;

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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

	private int teacher_id;
	@NotBlank(message = "First name is required")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "First name must contain only letters")
	private String first_name;
	@NotBlank(message = "Last name is required")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Last name must contain only letters")
	private  String last_name;
	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Invalid email address")
	private  String email;
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[!@#$%^&*()-+=])(?=.*[a-z]).{8,}$", message = "Password must be at least 8 characters long and contain one uppercase letter, one special character, and one lowercase letter")
	private  String password;
	@NotBlank(message = "Address is required")
	private  String address;
	@NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^\\d{10}$", message = "Invalid phone number format")
	private  String phone_number;
	@NotBlank(message = "Gender is required")
	@Pattern(regexp = "^(Male|Female)$", message = "Gender must be Male or Female")
	private  String gender;
	private  Date dob;
	private  String position;
	@NotNull(message = "Is admin value cannot be null")
    @Pattern(regexp = "^(0|1)$", message = "Is admin value must be either 0 or 1")
	private  int is_admin;
	
	
	
	public TeacherDTO(int teacher_id,
			@NotBlank(message = "First name is required") @Pattern(regexp = "^[a-zA-Z]+$", message = "First name must contain only letters") String first_name,
			@NotBlank(message = "Last name is required") @Pattern(regexp = "^[a-zA-Z]+$", message = "Last name must contain only letters") String last_name,
			@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Invalid email address") String email,
			@Pattern(regexp = "^(?=.*[A-Z])(?=.*[!@#$%^&*()-+=])(?=.*[a-z]).{8,}$", message = "Password must be at least 8 characters long and contain one uppercase letter, one special character, and one lowercase letter") String password,
			@NotBlank(message = "Address is required") String address,
			@NotBlank(message = "Phone number is required") @Pattern(regexp = "^\\d{10}$", message = "Invalid phone number format") String phone_number,
			@NotBlank(message = "Gender is required") @Pattern(regexp = "^(Male|Female)$", message = "Gender must be Male or Female") String gender,
			Date dob, String position,
			@NotNull(message = "Is admin value cannot be null") @Pattern(regexp = "^(0|1)$", message = "Is admin value must be either 0 or 1") int is_admin) {
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


	public TeacherDTO() {}
	

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

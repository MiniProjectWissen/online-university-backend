package com.example.university.dto;

import java.sql.Date;


import jakarta.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentDTO {

	private int stud_id;
	@NotBlank(message = "First name is required")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "First name must contain only letters")
	private String first_name;
    @NotBlank(message = "Last name is required")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Last name must contain only letters")
	private String last_name;
	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Invalid email address")
	private String email;
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[!@#$%^&*()-+=])(?=.*[a-z]).{8,}$", message = "Password must be at least 8 characters long and contain one uppercase letter, one special character, and one lowercase letter")
	private String password;
	@NotBlank(message = "Address is required")
	private String address;

	@NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^\\d{10}$", message = "Invalid phone number format")

	

	private String phone_number;
	@NotBlank(message = "Gender is required")
	@Pattern(regexp = "^(Male|Female)$", message = "Gender must be Male or Female")
	private String gender;
	private Date dob;

	@Pattern(regexp = "^\\d{4}$", message = "Roll number must be 4 digits")
	private String roll_no;
    @Min(value = 1, message = "Standard must be at least 1")
    @Max(value = 17, message = "Standard must be at most 17")

	


	private int standard;
	
	public StudentDTO() {}

	public int getStud_id() {
		return stud_id;
	}
	public void setStud_id(int stud_id) {
		this.stud_id = stud_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	
	public StudentDTO(int stud_id,
			@NotBlank(message = "First name is required") @Pattern(regexp = "^[a-zA-Z]+$", message = "First name must contain only letters") String first_name,
			@NotBlank(message = "Last name is required") @Pattern(regexp = "^[a-zA-Z]+$", message = "Last name must contain only letters") String last_name,
			@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Invalid email address") String email,
			@Pattern(regexp = "^(?=.*[A-Z])(?=.*[!@#$%^&*()-+=])(?=.*[a-z]).{8,}$", message = "Password must be at least 8 characters long and contain one uppercase letter, one special character, and one lowercase letter") String password,
			@NotBlank(message = "Address is required") String address,
			@NotBlank(message = "Phone number is required") @Pattern(regexp = "^\\d{10}$", message = "Invalid phone number format") String phone_number,
			@NotBlank(message = "Gender is required") @Pattern(regexp = "^(Male|Female)$", message = "Gender must be Male or Female") String gender,
			Date dob, @Pattern(regexp = "^\\d{4}$", message = "Roll number must be 4 digits") String roll_no,
			@Min(value = 1, message = "Standard must be at least 1") @Max(value = 17, message = "Standard must be at most 17") int standard) {
		super();
		this.stud_id = stud_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
		this.address = address;
		this.phone_number = phone_number;
		this.gender = gender;
		this.dob = dob;
		this.roll_no = roll_no;
		this.standard = standard;
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
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRoll_no() {
		return roll_no;
	}
	public void setRoll_no(String roll_no) {
		this.roll_no = roll_no;
	}
	public int getStandard() {
		return standard;
	}
	public void setStandard(int standard) {
		this.standard = standard;
	}
	
	
	

}

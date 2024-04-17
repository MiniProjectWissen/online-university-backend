package com.example.university.dto;



public class UserDTO {

	public UserDTO() {
		
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	

	public UserDTO(String email, String password, String role) {
		super();
		this.email = email;
		this.password = password;
		this.role = role;
	}


	private String email;
	private String password;
	private String role;

}

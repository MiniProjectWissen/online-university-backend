package com.example.university.dto;

import java.sql.Timestamp;

public class MessageDTO {

	public MessageDTO() {
		// TODO Auto-generated constructor stub
	}
	private int message_id;
	private int forum_id;
	private int user_id;
	private String first_name;
	private String message;
	private Timestamp timestamp;
	public int getForum_id() {
		return forum_id;
	}
	public void setForum_id(int forum_id) {
		this.forum_id = forum_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	public MessageDTO(int forum_id, int user_id, String first_name, String message, Timestamp timestamp) {
		super();
		this.forum_id = forum_id;
		this.user_id = user_id;
		this.first_name = first_name;
		this.message = message;
		this.timestamp = timestamp;
	}
	public int getMessage_id() {
		return message_id;
	}
	public void setMessage_id(int message_id) {
		this.message_id = message_id;
	}
	
	

}

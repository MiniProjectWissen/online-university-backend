package com.example.university.external.service;



import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.university.dto.UserDTO;



@FeignClient(name="ONLINE-UNIVERSITY-AUTH")
public interface AuthService {
	
	@PostMapping("/auth")
	public Object auth(@RequestBody UserDTO a);
	
	
	@PostMapping("/auth/add")
	public Object addUser(@RequestBody UserDTO a);
	
	
	@DeleteMapping("/auth/{userId}")
	public Object deleteStudent(@PathVariable String userId);
	

}

package com.example.university.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.university.dto.AuthenticationDTO;
import com.example.university.exception.InvalidStudentException;
import com.example.university.service.IAuthenticationService;

@RestController
@CrossOrigin("http://localhost:4200")
public class AuthController {

	@Autowired
	IAuthenticationService authService;
	
	@PostMapping("/auth")
	public ResponseEntity<Object> auth(@RequestBody AuthenticationDTO a)
	{
		Boolean b= authService.authenticate(a);
		if (b==true) return new ResponseEntity<>(Collections.singletonMap("msg","Authenticated successfully"), HttpStatus.OK);
		else throw new InvalidStudentException("Auth failed");
	}
}

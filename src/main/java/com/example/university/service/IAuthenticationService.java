package com.example.university.service;

import org.springframework.stereotype.Service;

import com.example.university.dto.AuthenticationDTO;

@Service
public interface IAuthenticationService {

	public Boolean authenticate(AuthenticationDTO authDTO);
}

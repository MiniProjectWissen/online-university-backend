package com.example.university.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.university.dao.IStudentDao;
import com.example.university.dao.ITeacherDao;
import com.example.university.dto.AuthenticationDTO;
import com.example.university.dto.StudentDTO;
import com.example.university.dto.TeacherDTO;
import com.example.university.service.IAuthenticationService;

@Service
public class AuthenticationServiceImpl implements IAuthenticationService{

	@Autowired
	IStudentDao studentDao;
	
	@Autowired
	ITeacherDao teacherDao;
	
	public Boolean authenticate(AuthenticationDTO authDTO)
	{
		if (authDTO.getRole().equals("Student"))
		{
			System.out.println(authDTO.getEmail()+" shshshh");
			if (studentDao.existsByEmail(authDTO.getEmail()))
			{
				StudentDTO studentDTO=studentDao.findByEmail(authDTO.getEmail());
				if (studentDTO.getEmail().equals(authDTO.getEmail()) && 
						studentDTO.getPassword().equals(authDTO.getPassword()))
				{
					return true;
				}
			}else {
				return false;
			}
		}else {
			if (teacherDao.existsByEmail(authDTO.getEmail()))
			{
				TeacherDTO teacherDTO=teacherDao.findByEmail(authDTO.getEmail());
				if (teacherDTO.getEmail().equals(authDTO.getEmail()) && 
						teacherDTO.getPassword().equals(authDTO.getPassword()))
				{
					return true;
				}
			}else {
				return false;
			}
		}
		return false;
	}
}

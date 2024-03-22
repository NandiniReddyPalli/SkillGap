package com.feuji.employeeservice.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feuji.employeeservice.entity.UserLoginEntity;
import com.feuji.employeeservice.repository.UserLoginRepo;
import com.feuji.employeeservice.service.UserLoginService;

@Service
public class UserLoginServiceImpl implements UserLoginService {

	@Autowired
	private UserLoginRepo userLoginRepo;

	public UserLoginEntity loginUser(String userEmail, String userPassword) {
		// Find user by email
		UserLoginEntity user = userLoginRepo.findByUserEmail(userEmail);

		if (user != null && user.getUserPassword().equals(userPassword)) {
			return user;
		} else {
			return null;
		}
	}
}

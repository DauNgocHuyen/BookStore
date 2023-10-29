package com.quynhanh.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private UserRepository userRepository;
	
	// check login 
	@Override
	public User checkLogin(String email, String password) {
		return userRepository.checkLogin(email, password);
	}

}

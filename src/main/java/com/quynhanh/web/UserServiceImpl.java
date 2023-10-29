package com.quynhanh.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	// Create new account
	@Override
	public void createNewAccount(User user) {
		userRepository.save(user);
	}

}

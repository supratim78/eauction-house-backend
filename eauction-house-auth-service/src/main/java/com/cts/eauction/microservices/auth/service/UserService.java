package com.cts.eauction.microservices.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.eauction.microservices.auth.model.User;
import com.cts.eauction.microservices.auth.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User registerUser(User user) {
		user = userRepository.save(user);
		return user;
	}
	
	public User login(User user) {
		user = userRepository.findByNameAndPassword(user.getName(), user.getPassword());
		return user;
	}
	
	public User findByEmail(User user) {
		user = userRepository.findByEmail(user.getEmail());
		return user;
	}

}

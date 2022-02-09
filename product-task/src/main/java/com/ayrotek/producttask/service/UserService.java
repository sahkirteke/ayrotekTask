package com.ayrotek.producttask.service;

import org.springframework.stereotype.Service;

import com.ayrotek.producttask.model.User;
import com.ayrotek.producttask.repository.UserRepository;

@Service
public class UserService {

	UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void saveUser(User user) {
		userRepository.save(user);
	}

}

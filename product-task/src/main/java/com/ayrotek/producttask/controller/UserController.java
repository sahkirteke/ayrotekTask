package com.ayrotek.producttask.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayrotek.producttask.model.User;
import com.ayrotek.producttask.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	UserService  userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	

	@PostMapping("/user-save")
	ResponseEntity<String>save(@RequestBody User user) {
		userService.saveUser(user);
		return ResponseEntity.ok("User saved");
	}
	
}

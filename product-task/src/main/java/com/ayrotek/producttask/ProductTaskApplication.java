package com.ayrotek.producttask;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ayrotek.producttask.model.User;
import com.ayrotek.producttask.repository.UserRepository;

@SpringBootApplication
public class ProductTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductTaskApplication.class, args);
	}
	
	@Bean
	CommandLineRunner createUser(UserRepository userRepository) {
		return (args) -> {
			User user  = new User();
			user.setEmail("husam@sad");
		 	userRepository.save(user);
		};
		
	}

}

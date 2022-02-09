package com.ayrotek.producttask.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ayrotek.producttask.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}

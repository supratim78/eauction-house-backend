package com.cts.eauction.microservices.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.eauction.microservices.auth.model.User;



public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByName(String name); 
	User findByEmail(String email);
	User findByNameAndPassword(String name, String password);
}

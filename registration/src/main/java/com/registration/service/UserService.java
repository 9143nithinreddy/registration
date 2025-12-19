package com.registration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registration.model.User;
import com.registration.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userrepository;
	
	//registration
	public User registeruser(User user) {
		if(userrepository.existsByEmail(user.getEmail())) {
			throw new RuntimeException("Email already exists");
		}
		return userrepository.save(user);
	}
	//getusers
	public List<User> getAllusers(){
		return userrepository.findAll();
	}
	

}

package com.registration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.registration.model.User;
import com.registration.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@PostMapping("/register")
	public User registeruser(@RequestBody User user) {
		return userservice.registeruser(user);
	}
	
	@GetMapping("/allusers")
	public List<User> getAllusers(){
		return userservice.getAllusers();
	}
	

}

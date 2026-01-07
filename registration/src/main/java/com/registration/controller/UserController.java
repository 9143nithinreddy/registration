package com.registration.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.registration.dto.LoginRequest;
import com.registration.model.User;
import com.registration.service.UserService;
import com.registration.util.JwtUtil;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private final UserService userservice;
	
	
	public  UserController(UserService userservice) {
		this.userservice=userservice;
		this.userservice.createadmin();
	}
	
	@PostMapping("/register")
	public String registeruser(@RequestBody User user) {
		return userservice.registeruser(user);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest request) {

	    String token = userservice.login(request);

	    return ResponseEntity.ok(
	        Map.of(
	            "success", true,
	            "token", token
	        )
	    );
	}
	
	@GetMapping("/allusers")
	public List<User> getAllusers(){
		return userservice.getAllusers();
	}
	
	@GetMapping("/validate")
	public String validateToken(@RequestHeader("Authorization") String token) {

	    return JwtUtil.isTokenValid(token)
	            ? "Valid token"
	            : "Invalid token";
	}
	

}

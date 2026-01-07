package com.registration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registration.dto.ApiResponse;
import com.registration.dto.LoginRequest;
import com.registration.model.User;
import com.registration.repository.UserRepository;
import com.registration.util.JwtUtil;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userrepository;
	private final JwtUtil jwtUtil = new JwtUtil();
	
	//registration
	public String  registeruser(User user) {
		if(userrepository.existsByEmail(user.getEmail())) {
			throw new RuntimeException("Email already exists");
		}
		user.setRole("user");
		 userrepository.save(user);
		 return "User registration is successfull";
	}
	
	
	//getusers
	public List<User> getAllusers(){
		return userrepository.findAll();
	}
	
	
	// login
	 public String login(LoginRequest request) {

	        User user = userrepository
	                .findByEmail(request.getEmail())
	                .orElseThrow(() -> new RuntimeException("User not found"));

	        if (!user.getPassword().equals(request.getPassword())) {
	            throw new RuntimeException("Invalid password");
	        }

	        // ✅ Generate JWT token
	        return jwtUtil.generateToken(user.getEmail());
	    }	
	
	public void createadmin() {
		if(!userrepository.existsByUsername("Admin")) {
			User admin= new User();
			admin.setUsername("admin");
			admin.setEmail("admin@gmail.com");
			admin.setPassword("admin123");
			admin.setPhno("7013558258");
			admin.setRole("admin");
			userrepository.save(admin);
			System.out.println("admin has been created");
			
		}
	}

}

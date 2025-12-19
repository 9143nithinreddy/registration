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

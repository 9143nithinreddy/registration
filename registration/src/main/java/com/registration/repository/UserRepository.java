package com.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.registration.model.User;

public interface UserRepository extends JpaRepository<User,Long>{

	boolean existsByEmail(String getEmail);

	boolean existsByUsername(String username);
	

}

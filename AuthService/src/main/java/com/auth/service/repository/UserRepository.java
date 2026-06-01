package com.auth.service.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.auth.service.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
       
	
	User findByUsername(String username);
}

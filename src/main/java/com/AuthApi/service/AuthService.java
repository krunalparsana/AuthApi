package com.AuthApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.AuthApi.model.User;
import com.AuthApi.repository.UserRepo;

@Service
public class AuthService {
	@Autowired
	UserRepo repo;
	
	public User signupUser(String email,String password) {
		User user=new User();
		user.setEmail(email);
		user.setPassword(password);
		return repo.save(user);
	}
	
	public User login(String email,String password) {
		User user=repo.findByEmailAndPassword(email,password);
		return user;
	}
	

}
	
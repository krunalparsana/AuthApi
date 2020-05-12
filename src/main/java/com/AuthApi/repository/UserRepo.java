package com.AuthApi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AuthApi.model.User;
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	User findByEmailAndPassword(String email, String password);

	User findByEmail(String email);

}

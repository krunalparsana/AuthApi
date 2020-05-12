package com.AuthApi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.AuthApi.model.User;
import com.AuthApi.service.AuthService;

@RestController
@RequestMapping("/api")
public class Controller {

	@Autowired
	AuthService authenticationService;

	@GetMapping("/logout")
	public ResponseEntity<?> logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return ResponseEntity.ok("Logout Successfull");
	}

	@GetMapping("/dummy")
	public String testApi() {
		return "Hello User";
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user, HttpServletRequest request) {
		if (user != null) {
			User user1 = authenticationService.login(user.getEmail(), user.getPassword());
			if (user1 != null) {
				request.getSession().setAttribute("session", user1.getEmail());
				return ResponseEntity.ok("WELCOME!! " + user1.getEmail());
			}
		}
		return ResponseEntity.ok("INVALID EMAIL OR PASSWORD");
	}

	@PostMapping("/signup")
	public ResponseEntity<?> signup(@RequestBody User user) {
		User user1 = authenticationService.signupUser(user.getEmail(), user.getPassword());
		if (user1 != null)
			return ResponseEntity.ok("Successfully signep up for " + user.getEmail());
		else
			return ResponseEntity.ok("INVALID EMAIL OR PASSWORD");
	}

}

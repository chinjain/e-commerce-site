package com.cj.ecommercejwt.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cj.ecommercejwt.entity.User;
import com.cj.ecommercejwt.services.UserServices;

@RestController("/api/v1/user")
public class UserController {

	@Autowired
	private UserServices userService;

	@PostConstruct
	public void initRolesAndUser() {
		userService.initRolesAndUser();
	}

	@PostMapping("/create")
	public User registerUser(@RequestBody User user) {
		return userService.createUser(user);
	}

	@GetMapping("/forAdmin")
	public String forAdmin() {
		return "This url is only accessible for admin";
	}

	@GetMapping("/forUser")
	public String forUser() {
		return "This url is only accessible for User";
	}
}

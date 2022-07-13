package com.BikkadIT.UserManagementApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.UserManagementApplication.bindings.LoginForm;
import com.BikkadIT.UserManagementApplication.service.UserServiceImpl;

@RestController
public class Logincontroller {

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@PostMapping("/login")
	public String login(@RequestBody LoginForm loginForm) {
		String loginCheck = userServiceImpl.logincheck(loginForm);
		
		return loginCheck;
		
	}


}

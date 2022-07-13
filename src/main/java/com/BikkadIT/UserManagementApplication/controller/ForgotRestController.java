package com.BikkadIT.UserManagementApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.UserManagementApplication.service.UserServiceImpl;

@RestController
public class ForgotRestController {

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@GetMapping("/forgotPwd/{email}")
	public String forgotPassword(@PathVariable String email) {
		
		String forgotPassword=userServiceImpl.forgotPassword(email); 
		
		return forgotPassword;
	}
}

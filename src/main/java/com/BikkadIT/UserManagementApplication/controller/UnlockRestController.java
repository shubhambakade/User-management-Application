package com.BikkadIT.UserManagementApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.UserManagementApplication.bindings.UnlockAccForm;
import com.BikkadIT.UserManagementApplication.service.UserServiceImpl;

@RestController
public class UnlockRestController {

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@PostMapping("/Unlock")
	public String unlockAcc(@RequestBody UnlockAccForm unlockAccForm) {
		
		boolean unlockAccount=userServiceImpl.unlockAccount(unlockAccForm);
		  if (unlockAccount) {
			  return "ACCOUNT UNLOCKED";
		}
		return "FAIL TO  UNLOCK ACCOUNT";
	}
	
	
	
}

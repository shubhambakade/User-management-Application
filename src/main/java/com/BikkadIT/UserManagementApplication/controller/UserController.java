package com.BikkadIT.UserManagementApplication.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.UserManagementApplication.bindings.LoginForm;
import com.BikkadIT.UserManagementApplication.bindings.UserForm;
import com.BikkadIT.UserManagementApplication.entities.CityMasterEntity;
import com.BikkadIT.UserManagementApplication.entities.CountryMasterEntity;
import com.BikkadIT.UserManagementApplication.entities.StateMasterEntity;
import com.BikkadIT.UserManagementApplication.entities.UserMasterEntiry;
import com.BikkadIT.UserManagementApplication.service.UserServiceImpl;

@RestController
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@GetMapping("/getcountry")
	public ResponseEntity<CountryMasterEntity> getCountries(){
		
		Map<Integer,String> contries = userServiceImpl.getContries();
		
		return new ResponseEntity( contries,HttpStatus.OK);
	}
	
	@GetMapping("/getstates/{countryId}")
	public ResponseEntity<StateMasterEntity> getStates(@PathVariable Integer countryId){
	
		Map<Integer,String> states = userServiceImpl.getStates(countryId);
		
		return new ResponseEntity(states,HttpStatus.OK);
	}
	
	@GetMapping("/getcities/{stateId}")
	public ResponseEntity<CityMasterEntity> getCities(@PathVariable Integer stateId){
		
		Map<Integer,String> cities = userServiceImpl.getCities(stateId);
		
		return new ResponseEntity(cities,HttpStatus.OK);
		
	}
	
	@PostMapping("/saveuser")
	public ResponseEntity<UserMasterEntiry> saveUser(@RequestBody UserForm userForm){
		
		  boolean save = userServiceImpl.saveUser(userForm);
		 
		  if (save ==true) {
			
			  String msg ="user save successfully";
			  return new ResponseEntity(msg,HttpStatus.CREATED);
		}
		  else {
			  
			  String msg ="user not save successfully";
		return new ResponseEntity(msg,HttpStatus.BAD_REQUEST);
	 }
	}
}

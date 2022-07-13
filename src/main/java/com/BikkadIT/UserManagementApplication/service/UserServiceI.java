package com.BikkadIT.UserManagementApplication.service;

import java.util.Map;

import com.BikkadIT.UserManagementApplication.bindings.LoginForm;
import com.BikkadIT.UserManagementApplication.bindings.UnlockAccForm;
import com.BikkadIT.UserManagementApplication.bindings.UserForm;

public interface UserServiceI {

	public String logincheck(LoginForm loginForm);
	
	public Map<Integer, String> getContries();
	
	public Map<Integer, String> getStates(Integer countryId);
	
	public Map<Integer, String> getCities(Integer stateId);
	
	public boolean emailUnique(String mail);
	
	public boolean saveUser(UserForm userForm);
	
	public boolean unlockAccount(UnlockAccForm unlockAccForm);
	
	public String forgotPassword(String email);
}

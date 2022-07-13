package com.BikkadIT.UserManagementApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BikkadIT.UserManagementApplication.entities.UserMasterEntiry;

public interface UserRepo extends JpaRepository<UserMasterEntiry, Integer> {

	public UserMasterEntiry findByMailAndPassword(String mail, String password);
	
	public UserMasterEntiry findByMail(String mail);
}

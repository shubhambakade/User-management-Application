package com.BikkadIT.UserManagementApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BikkadIT.UserManagementApplication.entities.CountryMasterEntity;

public interface CountryRepo extends JpaRepository<CountryMasterEntity, Integer>{

}

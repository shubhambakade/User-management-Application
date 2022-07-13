package com.BikkadIT.UserManagementApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BikkadIT.UserManagementApplication.entities.StateMasterEntity;

public interface StateRepo extends JpaRepository<StateMasterEntity, Integer> {

	public List<StateMasterEntity> findByCountryId(Integer countryId);
}

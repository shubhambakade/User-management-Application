package com.BikkadIT.UserManagementApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BikkadIT.UserManagementApplication.entities.CityMasterEntity;

public interface CityRepo extends JpaRepository<CityMasterEntity, Integer>{

	public List<CityMasterEntity> findByStateId(Integer stateId);
}

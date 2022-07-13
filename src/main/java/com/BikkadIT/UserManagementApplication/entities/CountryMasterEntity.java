package com.BikkadIT.UserManagementApplication.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COUNTRY_MASTER")
public class CountryMasterEntity {
	
    
	@Id
	private int countryId;
	private String countryName;
	public int getCountryId() {
		return countryId;
	}
	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public CountryMasterEntity(int countryId, String countryName) {
		super();
		this.countryId = countryId;
		this.countryName = countryName;
	}
	
	public CountryMasterEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Country [countryId=" + countryId + ", countryName=" + countryName + "]";
	}
	
	
}

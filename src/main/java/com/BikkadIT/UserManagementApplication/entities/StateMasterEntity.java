package com.BikkadIT.UserManagementApplication.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STATE_MASTER")
public class StateMasterEntity {
	@Id
    @Column(name = "STATE_ID")
	private Integer stateId;
	@Column(name = "STATE_NAME")
	private String stateName;
    @Column(name = "COUNTRY_ID")
    private Integer countryId;
	
    @Override
	public String toString() {
		return "StateMasterEntity [stateId=" + stateId + ", stateName=" + stateName + ", countryId=" + countryId + "]";
	}
	public StateMasterEntity(Integer stateId, String stateName, Integer countryId) {
		super();
		this.stateId = stateId;
		this.stateName = stateName;
		this.countryId = countryId;
	}
	
	
	public StateMasterEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getStateId() {
		return stateId;
	}
	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public Integer getCountryId() {
		return countryId;
	}
	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}
	
	
	
}

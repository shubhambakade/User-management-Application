package com.BikkadIT.UserManagementApplication.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CITIES_MASTER")
public class CityMasterEntity {
    @Id
    @Column(name = "CITY_ID")
	private int cityId;
    @Column(name ="CITY_NAME")
	private String cityName;
    @Column(name = "STATE_ID")
    private Integer stateId;
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public Integer getStateId() {
		return stateId;
	}
	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}
	public CityMasterEntity(int cityId, String cityName, Integer stateId) {
		super();
		this.cityId = cityId;
		this.cityName = cityName;
		this.stateId = stateId;
	}
	public CityMasterEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CityMasterEntity [cityId=" + cityId + ", cityName=" + cityName + ", stateId=" + stateId + "]";
	}
    

	
}

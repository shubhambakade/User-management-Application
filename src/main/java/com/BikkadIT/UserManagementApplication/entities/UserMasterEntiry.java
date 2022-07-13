package com.BikkadIT.UserManagementApplication.entities;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "USER_DETAILS")
public class UserMasterEntiry {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
	private int Id;
    
    @Column(name = "USER_FIRST_NAME")
	private String FirstName;
    
    @Column(name = "USER_LAST_NAME")
	private String lastName;
    
    @Column(name = "USER_EMAIL")
	private String mail;
    
    @Column(name = "USER_PHONENO")
	private long phoneNo;
    
    @Column(name = "USER_DOB")
	private Date DOB;
    
    @Column(name = "GENDER_TYPE")
    private String gender;
    
    @Column(name = "COUNTRY_NAME")
    private String countryName;
    
    @Column(name = "STATE_NAME")
    private String stateName;
    
    @Column(name = "CITY_NAME")
    private String cityName;
    
    @Column(name = "ACCOUNT_STATUS")
    private String accountStatus;
    
    @Column(name = "PASSWORD")
    private String password;
    
    @Column(name = "UPDATE_DATE")
    @CreationTimestamp
    private LocalDate updateDate;
    
    @Column(name = "CREATE_DATE")
    @UpdateTimestamp
    private LocalDate createDate;
    
	
    @Override
	public String toString() {
		return "UserMasterEntiry [Id=" + Id + ", FirstName=" + FirstName + ", lastName=" + lastName + ", mail=" + mail
				+ ", phoneNo=" + phoneNo + ", DOB=" + DOB + ", gender=" + gender + ", countryName=" + countryName
				+ ", stateName=" + stateName + ", cityName=" + cityName + ", accountStatus=" + accountStatus
				+ ", password=" + password + ", updateDate=" + updateDate + ", createDate=" + createDate + "]";
	}

	

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDate updateDate) {
		this.updateDate = updateDate;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	

	
}

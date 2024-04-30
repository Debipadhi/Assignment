package com.hyscaler.cimm.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="AdminDetals")
public class AdminDetails {
	
	@Id
	private Integer Id;
	
	@Column(length=25)
	private String adminName;
	
	@Column(length=25)
	private String Email;
	
	@Column(length=25)
	private String adminPassword;
	
	
	//private EmployeeDetails salesEmployeeDetails;
	
	//private HolidayPackage holidays;
	
	
	

	public AdminDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
/*
	public EmployeeDetails getSalesEmployeeDetails() {
		return salesEmployeeDetails;
	}

	public void setSalesEmployeeDetails(EmployeeDetails salesEmployeeDetails) {
		this.salesEmployeeDetails = salesEmployeeDetails;
	}

	public HolidayPackage getHolidays() {
		return holidays;
	}

	public void setHolidays(HolidayPackage holidays) {
		this.holidays = holidays;
	}
*/
	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}
	
	
	
	
	
	


}

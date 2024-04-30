package com.hyscaler.cimm.Entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="Employee")
public class EmployeeDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length=25)
	private String  name;
	private Integer age;
	
	private Date    joining;
	private Date    exitcompany;
	
	@Column(length=25)
	private String  gender;
	
	@Column(length=25)
	private String  salesTertory;
	
	@Column(length=25)
	private String  Address;
	
	@Column(length=25)
	private String  Experience;
	
	private Double  target;
	@Column(length=25)
	private String  incentivePercentage;
	@Column(length=25)
	private String  bonus;
	
	@Column(length=25)
	private String  holidayPackageEligibility;
	
	
	@Column(length=25)
	private String  email;
	
	@Column(length=25)
	private String  password;
	
	
	
	
	//this is the constructor 0-arg constructor
	
	public EmployeeDetails() {
		super();
	}

	//this is the all arg constructor
	/*
	public EmployeeDetails(Integer id, String name, Integer age, Date joining, Date exitcompany, String gender,
			String salesTertory, String address, String experience, Double target, String incentivePercentage,
			String bonus, String holidayPackageEligibility, String password) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.joining = joining;
		this.exitcompany = exitcompany;
		this.gender = gender;
		this.salesTertory = salesTertory;
		Address = address;
		Experience = experience;
		this.target = target;
		this.incentivePercentage = incentivePercentage;
		this.bonus = bonus;
		this.holidayPackageEligibility = holidayPackageEligibility;
		this.password = password;
	}
	*/
	
	//here is the getters and setters method
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getJoining() {
		return joining;
	}
	public void setJoining(Date joining) {
		this.joining = joining;
	}
	public Date getExitcompany() {
		return exitcompany;
	}
	public void setExitcompany(Date exitcompany) {
		this.exitcompany = exitcompany;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSalesTertory() {
		return salesTertory;
	}
	public void setSalesTertory(String salesTertory) {
		this.salesTertory = salesTertory;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getExperience() {
		return Experience;
	}
	public void setExperience(String experience) {
		Experience = experience;
	}
	public Double getTarget() {
		return target;
	}
	public void setTarget(Double target) {
		this.target = target;
	}
	public String getIncentivePercentage() {
		return incentivePercentage;
	}
	public void setIncentivePercentage(String incentivePercentage) {
		this.incentivePercentage = incentivePercentage;
	}
	public String getBonus() {
		return bonus;
	}
	public void setBonus(String bonus) {
		this.bonus = bonus;
	}
	public String getHolidayPackageEligibility() {
		return holidayPackageEligibility;
	}
	public void setHolidayPackageEligibility(String holidayPackageEligibility) {
		this.holidayPackageEligibility = holidayPackageEligibility;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}

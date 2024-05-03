package com.hyscaler.cimm.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyscalar.cimm.utill.EmailUtils;
import com.hyscaler.cimm.Entity.EmployeeDetails;
import com.hyscaler.cimm.Entity.HolidayPackage;
import com.hyscaler.cimm.Repository.EmployeeRepo;
import com.hyscaler.cimm.Repository.HolidaysPackageRepo;

@Service
public class EmployeeServiceIMPL implements EmployeeService {
	
	@Autowired
	private EmployeeRepo employeerepo;
	
	@Autowired
	private HolidaysPackageRepo repo;
	
	@Autowired
	private EmailUtils emailutils;
	
	@Override
	public EmployeeDetails getEmployeeDetails(Integer id) {
		Optional<EmployeeDetails>  optionalpkg = employeerepo.findById(id);
		if(optionalpkg.isPresent()) {
			
			EmployeeDetails emp = optionalpkg.get();
			return emp;
		}
		return null;
	}

	@Override
	public String isHolidaypkg(Integer id ) {
		
		Optional<EmployeeDetails>  optionalpkg = employeerepo.findById(id);
		if(optionalpkg.isPresent()) {
			
			EmployeeDetails emp = optionalpkg.get();
			if(emp.getHolidayPackageEligibility()== "yes") {
				Optional<HolidayPackage> holiday=repo.findById(id);
				
			}
			return "";
		}
		return null;
	}

	@Override
	public EmployeeDetails checklogin(String email, String password,Integer id) {
		
		Optional<EmployeeDetails>  list = employeerepo.findById(id);
		EmployeeDetails emp = null;
		if(list.isPresent()) {
			emp= list.get();
		}
		
		if(emp.getEmail().equals(email) && emp.getPassword().contains(password)) {
			return emp;
		}
		
		return null;
	}

	@Override
	public String addemployee(EmployeeDetails employee) {
		EmployeeDetails findbyemail  = employeerepo.findByEmail(employee.getEmail());
		
		if(findbyemail == null) {
			EmployeeDetails employeedata =employeerepo.save(employee);
			if(employeedata == null) {
				return "some internal problem is happning";
			}
			
			return "please note id- "+employeedata.getId()+" your recored successfully submited";
		}
		
		return "this email"+findbyemail.getEmail()+"already register";
	}

	@Override
	public EmployeeDetails getEmployeeDetailsByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean recoverpassword(String email) {
		EmployeeDetails emp = employeerepo.findByEmail(email);
		
		if(emp.getId() == null) {
			return false;
		}
		
		String subject= "Recover Password - employee MR. "+ emp.getName();
		String body ="<h1>id:- "+emp.getId()+"<h1>Your Passvord :- "+emp.getPassword()+"</h1>";
		
		
		
		return emailutils.sendEmail(subject, body, email) ;
	}

	
}

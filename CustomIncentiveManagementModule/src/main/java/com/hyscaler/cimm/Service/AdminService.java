package com.hyscaler.cimm.Service;

import java.util.List;

import com.hyscaler.cimm.Entity.AdminDetails;
import com.hyscaler.cimm.Entity.EmployeeDetails;
import com.hyscaler.cimm.Entity.HolidayPackage;

public interface AdminService {
	
	   // these methods for Employee
	
	   public  String addEmployee(EmployeeDetails employee);

	   public  String updateEmployeeById(Integer id,EmployeeDetails employee);

	   public  String deleteEmployee(Integer employeeId);

	   public  EmployeeDetails getEmployeeById(Integer employeeId);

	   public   List<EmployeeDetails> getAllEmployees();

	    // Holiday Package related methods

	   public  String addHolidayPackage(HolidayPackage holidayPackage);

	   public  String  updateHolidayPackage(Integer id,HolidayPackage holidayPackage);

	   public  String deleteHolidayPackage(Integer packageId);

	   public  HolidayPackage getHolidayPackageById(Integer id);

	   public  List<HolidayPackage> getAllHolidayPackages();
	   
	   //this for the admin 
	   
	   public  AdminDetails getAdminDetailsById(Integer id);
	   
	   public  String createAdmin(AdminDetails admin);
	   
	   public  String updateAdmin(Integer id,AdminDetails admin);
	   
	   public AdminDetails checklogin(String email, String password);
	   
	   public AdminDetails getAdminDetailsByEmail(String email);
	   
	   public boolean recoverpassword(String email);

	  
}

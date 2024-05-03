package com.hyscaler.cimm.Service;

import com.hyscaler.cimm.Entity.EmployeeDetails;

public interface EmployeeService {
	
	public String addemployee(EmployeeDetails employee);
	public EmployeeDetails getEmployeeDetails(Integer id);
	public String isHolidaypkg(Integer id);
	public EmployeeDetails checklogin(String email,String password,Integer id);
	public EmployeeDetails getEmployeeDetailsByEmail(String email);
	public boolean recoverpassword(String email);

}

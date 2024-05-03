package com.hyscaler.cimm.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import com.hyscaler.cimm.Entity.AdminDetails;
import com.hyscaler.cimm.Entity.EmployeeDetails;
import com.hyscaler.cimm.Entity.HolidayPackage;
import com.hyscaler.cimm.Repository.EmployeeRepo;
import com.hyscaler.cimm.Service.AdminService;
import com.hyscaler.cimm.Service.EmployeeService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
//@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService service;
	
	@Autowired
	private EmployeeService employeeservice;

	
	@GetMapping("/admin")
	public String index(Model model) {
		model.addAttribute("AdminDetails", new AdminDetails());
		return "adminlogin";
	}
	
	@PostMapping("/admin/login")
	public String hendellogin(AdminDetails admin, Model model) {
		
		AdminDetails admincheck = service.checklogin(admin.getEmail(),admin.getAdminPassword()); 
		if(admincheck == null) {
			model.addAttribute("meag", "invalis user id and password");
			return "adminlogin";
		}
		return "redirect:/admin/admindashboard";
	}
	
	
	@GetMapping("/adin/recoverpassword")
	public String Employeerecover() {
		
		return "adminPWDrecover";
	}
	@PostMapping("/admin/recoverpassword")
	public String Employeepasswordrecover(Model model,AdminDetails admin) {
		
		boolean admin1=service.recoverpassword(admin.getEmail());
		if(admin1== false) {
			model.addAttribute("invalid","Invalid Email Id");
			return "employeePWDrecover";
		}
		
		model.addAttribute("valid", "password send to your email adddress");  
		
		return "redirect:/admin/login";
	}
	
	
	
	@GetMapping("/admin/admindashboard")
	public String buildDashBoard(Model model) {
		
		return "admindashboard";
	}
	
	@GetMapping("/admin/viewallemployee")
	public String viewallEmployee(Model model,HttpServletRequest req) {
		List<EmployeeDetails> EmployeeDetails = service.getAllEmployees();
		model.addAttribute("mesg", EmployeeDetails);
		
		HttpSession session = req.getSession(true);
		session.setAttribute("employeedetailslist", EmployeeDetails);
		return "viewallemployee";
	}
	
	@GetMapping("/admin/addemployee")
	public String addEmployee(EmployeeDetails emp,Model model) {
		//String message = service.addEmployee(emp);
		//model.addAttribute("mesg",message);
		return "addemployee";
	}
	@PostMapping("/admin/addemployee")
	public String addEmployeeoperation(EmployeeDetails emp,Model model) {
		Date dt =(Date)emp.getJoining();
		emp.setJoining(dt);
		String message = service.addEmployee(emp);
		model.addAttribute("mesg",message);
		return "redirect:/admin/viewallemployee";
	}
	
	@GetMapping("/admin/updateemployee/{id}")
	public String UpdateEmployeeemp(EmployeeDetails emp,Model model,@PathVariable("id") Integer id) {
		
		EmployeeDetails Employees = service.getEmployeeById(id);
		 model.addAttribute("emp", Employees);
		return "updateemployee";
	}
	
	@PostMapping("/admin/updateemployee")
	public String UpdateEmployee(@ModelAttribute EmployeeDetails emp,Model model) {
		
		System.out.println("AdminController.UpdateEmployee()line 103 update employee method controller" );
		
		Date dt =(Date)emp.getJoining();
		emp.setJoining(dt);
		Integer empid =(Integer) emp.getId();
		
		String update = service.updateEmployeeById(empid, emp);
		model.addAttribute("update", update);
		
		return "redirect:/admin/viewallemployee";
	}
	
	@DeleteMapping("/admin/deleteemployee/{id}")
	public String deleteEmployee(EmployeeDetails emp,Model model,@PathVariable("id") Integer id) {
		
		String delete = service.deleteEmployee(id);
		model.addAttribute(delete, delete);
		
		return "redirect:/admin/viewallemployee";
	}
	
	
	@PostMapping("/admin/addholiday")
	public String addHoliday() {
		
		return "admindashboard";
	}
	@PutMapping("/admin/updateholiday")
	public String Updateholiday() {
		
		return "admindashboard";
	}
	
	@DeleteMapping("/admin/deleteholiday")
	public String deleteholiday() {
		
		return "admindashboard";
	}
}

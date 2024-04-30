package com.hyscaler.cimm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hyscaler.cimm.Entity.AdminDetails;
import com.hyscaler.cimm.Entity.EmployeeDetails;
import com.hyscaler.cimm.Service.EmployeeService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping("/employee")
	public String index(Model model) {
		model.addAttribute("EmployeeDetails", new EmployeeDetails());
		return "employeelogin";
	}
	
	@PostMapping("/login")
	public String hendellogin(EmployeeDetails emp, Model model, HttpServletRequest req) {
		EmployeeDetails admincheck = service.checklogin(emp.getEmail(),emp.getPassword(),emp.getId()); 
		
		
		if(admincheck == null) {
			model.addAttribute("mesg", "invalid id, username and password");
			return"employeelogin";
		}
		
		HttpSession session  = req.getSession(true);
		session.setAttribute("id", emp.getId());
		return "redirect:employeedashboard";
	}
	
	@GetMapping("/employeedashboard")
	public String buildDashBoard(Model model, HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		Object obj= session.getAttribute("id");
		Integer id = (Integer)obj;
		
		EmployeeDetails employeedeails= service.getEmployeeDetails(id);

		model.addAttribute("EmployeeDetails",employeedeails );
		
		return "employeedashboard";
	}
}

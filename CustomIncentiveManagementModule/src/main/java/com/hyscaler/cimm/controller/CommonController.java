package com.hyscaler.cimm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.hyscaler.cimm.Entity.AdminDetails;

@Controller
public class CommonController {
	
	@GetMapping("/")
	public String index(Model model) {
		//model.addAttribute("AdminDetails", new AdminDetails());
		return "home";
	}
	
	
}

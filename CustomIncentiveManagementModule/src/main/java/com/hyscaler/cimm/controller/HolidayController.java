package com.hyscaler.cimm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hyscaler.cimm.Entity.HolidayPackage;
import com.hyscaler.cimm.Service.HolidayService;

@RestController
@RequestMapping("/holidayPackage")
public class HolidayController {
	
	@Autowired
	private HolidayService holidayservice;
	
	@GetMapping("/getdall")
    public List<HolidayPackage> getAllPackages() {
        return holidayservice.getAllPackages();
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<HolidayPackage> getPackageById(@PathVariable Integer id) {
		HolidayPackage holidayPackage = holidayservice.getPackageById(id);
	    return ResponseEntity.ok(holidayPackage);
	}
	

}

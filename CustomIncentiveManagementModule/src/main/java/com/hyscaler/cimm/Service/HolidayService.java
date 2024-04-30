package com.hyscaler.cimm.Service;

import java.util.List;

import com.hyscaler.cimm.Entity.HolidayPackage;

public interface HolidayService {
	 public  List<HolidayPackage> getAllPackages();
	 public  HolidayPackage getPackageById(Integer  id);
	 public  String createPackage(HolidayPackage holidayPackage);
	 public  String updatePackage(Integer id, HolidayPackage holidayPackage);
	 public  String deletePackage(Integer id);
}

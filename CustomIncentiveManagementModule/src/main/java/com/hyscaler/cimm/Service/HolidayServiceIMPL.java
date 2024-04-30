package com.hyscaler.cimm.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyscaler.cimm.Entity.HolidayPackage;
import com.hyscaler.cimm.Repository.HolidaysPackageRepo;

@Service
public class HolidayServiceIMPL implements HolidayService {
	
	@Autowired
	private HolidaysPackageRepo holidayrepo;

	@Override
	public List<HolidayPackage> getAllPackages() {
		
		List<HolidayPackage> holidaylist = holidayrepo.findAll();
		return holidaylist;
		
	}

	@Override
	public HolidayPackage getPackageById(Integer  id) {
		
		Optional<HolidayPackage>  optionalpkg=holidayrepo.findById(id);
		if(optionalpkg.isPresent()) {
			
			HolidayPackage holidatpkg = optionalpkg.get();
			return holidatpkg;
		}
		return null;
	}

	@Override
	public String createPackage(HolidayPackage holidayPackage) {
		
		HolidayPackage hpkg=  holidayrepo.save(holidayPackage);
		return "please Note this holiday package ID:- "+hpkg.getId();
	}

	@Override
	public String updatePackage(Integer  id, HolidayPackage holidayPackage) {
		
		if(holidayrepo.existsById(id)) {
			holidayrepo.save(holidayPackage);
			return id+"this id  record  updated successfully";
		}
		
		return id+"no HolidayPackage is no Exit";
	}

	@Override
	public String deletePackage(Integer id) {
		
			holidayrepo.deleteById(id);
		return "the id no- "+ id +" package deleted successfully" ;
		
	}

}

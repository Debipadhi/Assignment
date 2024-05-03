package com.hyscaler.cimm.Service;

import java.sql.Time;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyscalar.cimm.utill.EmailUtils;
import com.hyscaler.cimm.Entity.AdminDetails;
import com.hyscaler.cimm.Entity.EmployeeDetails;
import com.hyscaler.cimm.Entity.HolidayPackage;
import com.hyscaler.cimm.Repository.AdminDetailsRepo;
import com.hyscaler.cimm.Repository.EmployeeRepo;
import com.hyscaler.cimm.Repository.HolidaysPackageRepo;

@Service
public class AdminserviceIMPL implements AdminService {

	// this repository for emploee class
	@Autowired
	private HolidaysPackageRepo holidayrepo;

	// this repository for emploee class
	@Autowired
	private EmployeeRepo employeerepo;

	// repository for admindetails
	@Autowired
	private AdminDetailsRepo adminrepo;
	
	@Autowired
	private EmailUtils emailutils;

	@Override
	public String addEmployee(EmployeeDetails employee) {

		EmployeeDetails empdata = employee;

		if (employee.getTarget() < 10000) {
			empdata.setIncentivePercentage("0");
			empdata.setBonus("0");
			empdata.setHolidayPackageEligibility("no");
			EmployeeDetails emp = employeerepo.save(empdata);
			return emp.getId() + "add sucessfully";

		} else if (employee.getTarget() >= 10000 && employee.getTarget() < 20000) {
			empdata.setIncentivePercentage("1.5");
			empdata.setBonus("0");
			empdata.setHolidayPackageEligibility("no");
			EmployeeDetails emp = employeerepo.save(empdata);
			return emp.getId() + "add sucessfully";

		} else if (employee.getTarget() >= 20000 && employee.getTarget() < 30000) {
			empdata.setIncentivePercentage("3");
			empdata.setBonus("none");
			empdata.setHolidayPackageEligibility("no");
			EmployeeDetails emp = employeerepo.save(empdata);
			return emp.getId() + "add sucessfully";

		} else if (employee.getTarget() >= 30000 && employee.getTarget() < 50000) {
			empdata.setIncentivePercentage("3.5");
			empdata.setBonus("$1000");
			empdata.setHolidayPackageEligibility("no");
			EmployeeDetails emp = employeerepo.save(empdata);
			return emp.getId() + "add sucessfully";
		} else if (employee.getTarget() >= 50000) {
			empdata.setIncentivePercentage("5.5");
			empdata.setBonus("None");
			empdata.setHolidayPackageEligibility("yes");
			EmployeeDetails emp = employeerepo.save(empdata);
			return emp.getId() + "add sucessfully";
		}

		return "your data can not added properly";
	}

	@Override
	public String updateEmployeeById(Integer id, EmployeeDetails employee) {

		if (employeerepo.existsById(id)) {
			EmployeeDetails empdata = employee;

			if (employee.getTarget() < 10000) {
				empdata.setIncentivePercentage("0");
				empdata.setBonus("0");
				empdata.setHolidayPackageEligibility("no");
				EmployeeDetails emp = employeerepo.save(empdata);
				return emp.getId() + "update sucessfully";

			} else if (employee.getTarget() >= 10000 && employee.getTarget() < 20000) {
				empdata.setIncentivePercentage("1.5");
				empdata.setBonus("0");
				empdata.setHolidayPackageEligibility("no");
				EmployeeDetails emp = employeerepo.save(empdata);
				return emp.getId() + "update sucessfully";

			} else if (employee.getTarget() >= 20000 && employee.getTarget() < 30000) {
				empdata.setIncentivePercentage("3");
				empdata.setBonus("none");
				empdata.setHolidayPackageEligibility("no");
				EmployeeDetails emp = employeerepo.save(empdata);
				return emp.getId() + "update sucessfully";

			} else if (employee.getTarget() >= 30000 && employee.getTarget() < 50000) {
				empdata.setIncentivePercentage("3.5");
				empdata.setBonus("$1000");
				empdata.setHolidayPackageEligibility("no");
				EmployeeDetails emp = employeerepo.save(empdata);
				return emp.getId() + "add sucessfully";
			} else if (employee.getTarget() >= 50000) {
				empdata.setIncentivePercentage("5.5");
				empdata.setBonus("None");
				empdata.setHolidayPackageEligibility("yes");
				EmployeeDetails emp = employeerepo.save(empdata);
				return emp.getId() + "update sucessfully";
			}
		}

		return id + "this id  record is not exit";
	}

	@Override
	public String deleteEmployee(Integer employeeId) {
		employeerepo.deleteById(employeeId);
		return employeeId + " Employee has deleted successfylly";
	}

	@Override
	public EmployeeDetails getEmployeeById(Integer employeeId) {

		System.out.println("AdminserviceIMPL.getEmployeeById()");
		Optional<EmployeeDetails> optionalpkg = employeerepo.findById(employeeId);

		System.out.println(optionalpkg);

		if (optionalpkg.isPresent()) {

			System.out.println("AdminserviceIMPL.getEmployeeById().inside if condition line 57");
			EmployeeDetails emp = optionalpkg.get();
			return emp;
		}
		return null;
	}

	@Override
	public List<EmployeeDetails> getAllEmployees() {
		List<EmployeeDetails> employeelist = employeerepo.findAll();
		return employeelist;

	}

	// holiday manupulation get start

	@Override
	public String addHolidayPackage(HolidayPackage holidayPackage) {

		HolidayPackage hpkg = holidayrepo.save(holidayPackage);
		return "please Note this holiday package ID:- " + hpkg.getId();

	}

	@Override
	public String updateHolidayPackage(Integer id, HolidayPackage holidayPackage) {

		if (holidayrepo.existsById(id)) {
			holidayrepo.save(holidayPackage);
			return id + "this id  record  updated successfully";
		}

		return id + "no HolidayPackage is no Exit";

	}

	@Override
	public String deleteHolidayPackage(Integer packageId) {

		holidayrepo.deleteById(packageId);

		return "the id no- " + packageId + " package deleted successfully";

	}

	@Override
	public HolidayPackage getHolidayPackageById(Integer id) {

		Optional<HolidayPackage> optionalpkg = holidayrepo.findById(id);
		if (optionalpkg.isPresent()) {

			HolidayPackage holidatpkg = optionalpkg.get();
			return holidatpkg;
		}
		return null;
	}

	@Override
	public List<HolidayPackage> getAllHolidayPackages() {

		List<HolidayPackage> holidaylist = holidayrepo.findAll();
		return holidaylist;
	}

	// from this onword admin operation

	@Override
	public AdminDetails getAdminDetailsById(Integer id) {

		Optional<AdminDetails> ad = adminrepo.findById(id);
		if (ad.isPresent()) {

			AdminDetails admin = ad.get();
			return admin;
		}
		return null;
	}

	@Override
	public String createAdmin(AdminDetails admin) {
		AdminDetails hpkg = adminrepo.save(admin);
		return "please Note this holiday package ID:- " + hpkg.getId();
	}

	@Override
	public String updateAdmin(Integer id, AdminDetails admin) {
		if (adminrepo.existsById(id)) {
			adminrepo.save(admin);
			return id + "this id  record  updated successfully";
		}

		return id + "no admin is no Exit";
	}

	@Override
	public AdminDetails checklogin(String email, String password) {

		AdminDetails admindetails = adminrepo.findByEmail(email);

		if (admindetails.getEmail().equals(email) && admindetails.getAdminPassword().equals(password)) {
			return admindetails;
		}
		return null;
	}

	@Override
	public AdminDetails getAdminDetailsByEmail(String email) {

		AdminDetails admin = adminrepo.findByEmail(email);

		return admin;
	}

	@Override
	public boolean recoverpassword(String email) {
		AdminDetails admin =adminrepo .findByEmail(email);

		if (admin.getId() == null) {
			return false;
		}

		String subject = "Recover Password - employee MR. " + admin.getAdminName();
		String body = "<h1>id:- " + admin.getId() + "<h1>Your Passvord :- " + admin.getAdminPassword() + "</h1>";

		return emailutils.sendEmail(subject, body, email);
		
	}

}

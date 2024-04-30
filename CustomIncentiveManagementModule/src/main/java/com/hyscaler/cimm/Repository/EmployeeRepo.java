package com.hyscaler.cimm.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hyscaler.cimm.Entity.EmployeeDetails;

public interface EmployeeRepo extends JpaRepository<EmployeeDetails, Integer> {
	
	@Query("select e from EmployeeDetails e where e.email= :emailId")
	public EmployeeDetails findByEmail(@Param("emailId")String email);
}

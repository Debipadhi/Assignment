package com.hyscaler.cimm.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hyscaler.cimm.Entity.AdminDetails;
import com.hyscaler.cimm.Entity.EmployeeDetails;

public interface AdminDetailsRepo extends JpaRepository<AdminDetails, Integer> {
	
	@Query("select a from AdminDetails a where a.Email= :emailId")
	public AdminDetails findByEmail(@Param("emailId")String email);

}

/**
 * 
 */
package com.accenture.microservices.emp.details.data.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.microservices.emp.details.data.EmployeeDetails;

/**
 * @author j.venugopalan
 *
 */
public interface EmployeeRepository extends JpaRepository<EmployeeDetails, Long>{
	
	public Collection<EmployeeDetails> findByLastName(String lastName);
	public Collection<EmployeeDetails> findById(long id);
}

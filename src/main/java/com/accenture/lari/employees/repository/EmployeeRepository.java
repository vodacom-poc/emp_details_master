/**
 * 
 */
package com.accenture.lari.employees.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.lari.employees.domain.EmployeeDetails;

/**
 * @author j.venugopalan
 *
 */
public interface EmployeeRepository extends JpaRepository<EmployeeDetails, Long>{
	
	public EmployeeDetails findByLastName(String lastName);
	public EmployeeDetails findById(long id);
	public List<EmployeeDetails> findAll();
	public void delete(Long id) ;
	public boolean exists(Long id);
}

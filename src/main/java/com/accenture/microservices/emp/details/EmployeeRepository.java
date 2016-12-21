/**
 * 
 */
package com.accenture.microservices.emp.details;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author j.venugopalan
 *
 */
interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	public Collection<Employee> findByLastName(String lastName);
	public Collection<Employee> findById(long id);
}

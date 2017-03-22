/**
 * 
 */
package com.accenture.lari.employees.service;

import java.util.List;

import com.accenture.lari.employees.domain.EmployeeDetails;

/**
 * @author j.venugopalan
 *
 */
public interface EmpDetailsService {

	public EmployeeDetails getEmployeeDetails(long id) throws Exception;
	
	public List<EmployeeDetails> getAllEmployees() throws Exception;	
	
	public String deleteEmployeeDetails(long id) throws Exception;
}

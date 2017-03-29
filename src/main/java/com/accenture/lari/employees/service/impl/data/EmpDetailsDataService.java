package com.accenture.lari.employees.service.impl.data;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.accenture.lari.employees.domain.EmployeeDetails;
import com.accenture.lari.employees.repository.EmployeeRepository;



/**
 * @author mahima.agarwal
 *
 */
public class EmpDetailsDataService {
	public static final Logger log = LoggerFactory.getLogger(EmpDetailsDataService.class);
	
	public static EmployeeRepository employeeRepository;
	
	public EmpDetailsDataService(EmployeeRepository employeeRepository){
		EmpDetailsDataService.employeeRepository = employeeRepository;
	}

	public EmployeeDetails getEmployeeDetails(long id) throws Exception{
		log.info("EmpDetailsDataService getEmployeeDetails Employee ID passed: "+id);
		EmployeeDetails emplDetails = employeeRepository.findById(id);
		log.info("EmpDetailsDataService getEmployeeDetails Employee Details:"+ emplDetails);
		return emplDetails;
	}
		
	public List<EmployeeDetails> getAllEmployees() throws Exception{
		log.info("EmpDetailsDataService getAllEmployees ");
		List<EmployeeDetails> emplList = new ArrayList<EmployeeDetails>();
		emplList = employeeRepository.findAll();
		log.info("EmpDetailsDataService getAllEmployees List:: " + emplList);
		return emplList;
	}
	
	public EmployeeDetails findEmployeeByLastName(String lastName) throws Exception{
		log.info("EmpDetailsDataService findEmployeeByLastName Employee Lastname passed: "+lastName);
		EmployeeDetails emplDetails = employeeRepository.findByLastName(lastName);
		log.info("EmpDetailsDataService findEmployeeByLastName Employee Details:"+ emplDetails);
		return emplDetails;
	}
	
	public boolean deleteEmployeeDetails(long id) throws Exception{
		log.info("EmpDetailsDataService DeleteEmployeeDetails Employee ID passed: "+id);
		employeeRepository.delete(id);
		return true;
	}
	
	public boolean checkEmployeeExists(long id) throws Exception{
		log.info("EmpDetailsDataService DeleteEmployeeDetails Employee ID passed: "+id);
		boolean result = employeeRepository.exists(id);
		return result;
	}
	
}

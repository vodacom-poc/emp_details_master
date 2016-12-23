package com.accenture.microservices.emp.details.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.accenture.microservices.emp.details.data.EmployeeDetails;
import com.accenture.microservices.emp.details.data.service.EmpDetailsDataService;



/**
 * @author mahima.agarwal
 *
 */

@SpringBootApplication
@Component
@Service
public class EmpDetailsService {
	public static final Logger log = LoggerFactory.getLogger(EmpDetailsService.class);
	
	@Autowired
	EmpDetailsDataService empDetailsDataService;
	
	public EmployeeDetails getEmployeeDetails(long id) throws Exception{
		log.info("EmpDetailsService getEmployeeDetails: Employee ID "+id);
		EmployeeDetails empDetails = empDetailsDataService.getEmployeeDetails(id);
		return empDetails;
	}
	public boolean checkEmployeeExists(long id)throws Exception{
		log.info("EmpDetailsService checkEmployeeExists: Employee ID "+id);
		boolean result = false;
		result = empDetailsDataService.checkEmployeeExists(id);
		log.info("EmployeeDetails checkEmployeeExists result" + result);
		return result;
	}
	
	public List<EmployeeDetails> getAllEmployees() throws Exception{
		log.info("EmpDetailsService getAllEmployees ");
		List<EmployeeDetails> emplList = new ArrayList<EmployeeDetails>();
		emplList = empDetailsDataService.getAllEmployees();
		log.info("EmpDetailsService getAllEmployees List:: " + emplList);
		return emplList;
	}
	
	public String deleteEmployeeDetails(long id) throws Exception{
		log.info("EmpDetailsService DeleteEmployeeDetails Employee ID passed: "+id);
		String result = "false";
		if(checkEmployeeExists(id))
		{
			empDetailsDataService.deleteEmployeeDetails(id);
			result = "true";
		}else{
			result = "Employee Does not Exist. Please provide an existing employee";
		}
		return result;
	}
}

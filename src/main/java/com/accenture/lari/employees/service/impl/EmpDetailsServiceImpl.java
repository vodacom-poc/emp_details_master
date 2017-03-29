package com.accenture.lari.employees.service.impl;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.lari.employees.domain.EmployeeDetails;
import com.accenture.lari.employees.repository.EmployeeRepository;
import com.accenture.lari.employees.service.EmpDetailsService;
import com.accenture.lari.employees.service.impl.data.EmpDetailsDataService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @author mahima.agarwal
 * @Date:
 * @Last Update date:
 *
 */

@Service
public class EmpDetailsServiceImpl implements EmpDetailsService {
	public static final Logger log = LoggerFactory.getLogger(EmpDetailsServiceImpl.class);

	/*@Autowired
	EmpDetailsDataService empDetailsDataService;*/
	
	@Autowired
	EmployeeRepository employeeRepository;

	@HystrixCommand(fallbackMethod = "handleEmployeeDetails")
	public EmployeeDetails getEmployeeDetails(long id) throws Exception {
		log.info("EmpDetailsService getEmployeeDetails: Employee ID " + id);
		EmployeeDetails empDetails = employeeRepository.findById(id);//empDetailsDataService.getEmployeeDetails(id);
		return empDetails;
	}

	/**
	 * 
	 * @param id
	 * @param t
	 * @return: EmployeeDetails
	 * 
	 */

	public EmployeeDetails handleEmployeeDetails(long id, Throwable t) {
		log.info("fallback method  handleEmployeeDetails called,the error thrown is: " + getErrorStackTrace(t));
		EmployeeDetails employeeDetails = new EmployeeDetails();
		employeeDetails.setFirstName("Unknown");
		return employeeDetails;
	}

	public boolean checkEmployeeExists(long id) throws Exception {
		log.info("EmpDetailsService checkEmployeeExists: Employee ID " + id);
		boolean result = false;
		result = employeeRepository.exists(id);//empDetailsDataService.checkEmployeeExists(id);
		log.info("EmployeeDetails checkEmployeeExists result" + result);
		return result;
	}

	@HystrixCommand(fallbackMethod = "handleGetAllEmployees")
	public List<EmployeeDetails> getAllEmployees() throws Exception {
		log.info("EmpDetailsService getAllEmployees ");
		List<EmployeeDetails> emplList = new ArrayList<EmployeeDetails>();
		emplList = employeeRepository.findAll();//empDetailsDataService.getAllEmployees();
		log.info("EmpDetailsService getAllEmployees List:: " + emplList);
		return emplList;
	}

	public List<EmployeeDetails> handleGetAllEmployees(Throwable t) {

		log.info("fallback method  handleGetAllEmployees called,the error thrown is: " + getErrorStackTrace(t));
		return Arrays.asList(new EmployeeDetails());

	}

	public String deleteEmployeeDetails(long id) throws Exception {
		log.info("EmpDetailsService DeleteEmployeeDetails Employee ID passed: " + id);
		String result = "false";
		if (checkEmployeeExists(id)) {
			employeeRepository.delete(id);//empDetailsDataService.deleteEmployeeDetails(id);
			result = "true";
		} else {
			result = "Employee Does not Exist. Please provide an existing employee";
		}
		return result;
	}

	public String getErrorStackTrace(Throwable t) {

		if (t != null) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			t.printStackTrace(pw);
			return sw.toString();
		} else {
			return null;
		}

	}
}

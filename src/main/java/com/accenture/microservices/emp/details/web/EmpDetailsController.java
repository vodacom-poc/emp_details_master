/**
 * 
 */
package com.accenture.microservices.emp.details.web;

import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.accenture.microservices.emp.details.data.EmployeeDetails;
import com.accenture.microservices.emp.details.data.repository.EmployeeRepository;
import com.accenture.microservices.emp.details.service.EmpDetailsService;

/**
 * @author j.venugopalan
 *
 */
@org.springframework.web.bind.annotation.RestController
@SpringBootApplication
public class EmpDetailsController {
	private static final Logger log = LoggerFactory.getLogger(EmpDetailsController.class);
	
	@Autowired
	EmpDetailsService empDetailsService;
	
	@Autowired
	EmployeeRepository repository;
	@RequestMapping(value = "/employee/details/{empId}",method = RequestMethod.GET)
	
	public Collection<EmployeeDetails> getEmployeeDetails(@PathVariable ("empId") long id) throws Exception{
		Collection<EmployeeDetails> emplDetailsColl = empDetailsService.getEmployeeDetails(id);
		return emplDetailsColl;
	}
	
	
}

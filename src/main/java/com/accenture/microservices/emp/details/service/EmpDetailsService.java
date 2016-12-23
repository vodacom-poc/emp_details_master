package com.accenture.microservices.emp.details.service;

import java.util.Collection;

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
	
	public Collection<EmployeeDetails> getEmployeeDetails(long id) throws Exception{
		
		Collection<EmployeeDetails> empDetailsColl = empDetailsDataService.getEmployeeDetails(id);
		return empDetailsColl;
	}
	
	
}

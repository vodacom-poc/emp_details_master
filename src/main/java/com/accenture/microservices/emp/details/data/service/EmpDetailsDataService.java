package com.accenture.microservices.emp.details.data.service;

import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.accenture.microservices.emp.details.data.EmployeeDetails;
import com.accenture.microservices.emp.details.data.repository.EmployeeRepository;



/**
 * @author mahima.agarwal
 *
 */

@SpringBootApplication
@Component
@Service
public class EmpDetailsDataService {
	public static final Logger log = LoggerFactory.getLogger(EmpDetailsDataService.class);
	
	public static EmployeeRepository employeeRepository;
	
	public EmpDetailsDataService(EmployeeRepository employeeRepository){
		this.employeeRepository = employeeRepository;
	}

	public Collection<EmployeeDetails> getEmployeeDetails(long id) throws Exception{
		Collection<EmployeeDetails> emplList = new ArrayList<EmployeeDetails>();
//		//this.repository.findByEmployeeId(id);
		log.info("path variable: "+id);
		log.info(" employee: "+this.employeeRepository.findById(id));
		for (EmployeeDetails empl : this.employeeRepository.findById(id)){
			log.info("Employee details:"+empl.toString());
			emplList.add(empl);
		}

		return emplList;
	}
}

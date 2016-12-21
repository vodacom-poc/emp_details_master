/**
 * 
 */
package com.accenture.microservices.emp.details;

import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author j.venugopalan
 *
 */
@org.springframework.web.bind.annotation.RestController
@SpringBootApplication
@RequestMapping("/employee/{empId}")
public class RestController {
	private static final Logger log = LoggerFactory.getLogger(RestController.class);
	@RequestMapping(method = RequestMethod.GET)
	public Collection<Employee> getEmployeeDetails(@PathVariable ("empId") long id){
		Collection<Employee> emplList = new ArrayList<Employee>();
		//this.repository.findByEmployeeId(id);
		log.info("path variable: "+id);
		log.info(" employee: "+this.repository.findById(id));
		for (Employee empl : this.repository.findById(id)){
			log.info("Employee details:"+empl.toString());
			emplList.add(empl);
		}
		return emplList;
	}
	@ Autowired
	EmployeeRepository repository;
	
}

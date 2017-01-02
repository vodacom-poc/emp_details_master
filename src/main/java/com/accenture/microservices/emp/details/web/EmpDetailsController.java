/**
 * 
 */
package com.accenture.microservices.emp.details.web;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.microservices.emp.details.data.EmployeeDetails;
import com.accenture.microservices.emp.details.data.repository.EmployeeRepository;
import com.accenture.microservices.emp.details.service.EmpDetailsService;

/**
 * @author j.venugopalan
 *
 */
@RestController
@SpringBootApplication
public class EmpDetailsController {
	private static final Logger log = LoggerFactory.getLogger(EmpDetailsController.class);
	
	@Autowired
	EmpDetailsService empDetailsService;
	
	@Autowired
	EmployeeRepository repository;
	
	@RequestMapping(value = "/employees/{empId}",method = RequestMethod.GET)
	public EmployeeDetails getEmployeeDetails(@PathVariable ("empId") long id) throws Exception{
		log.info("EmpDetailsController path variable: Employee ID "+id);
		EmployeeDetails emplDetails = empDetailsService.getEmployeeDetails(id);
		if(null!=emplDetails){
			log.info("EmpDetailsController getEmployeeDetails result" + emplDetails.toString());
		}
		return emplDetails;
	}
	
//	@RequestMapping(value = "/employees/validate/{empId}",method = RequestMethod.GET)
//	public boolean validateEmployee(@PathVariable ("empId") long id) throws Exception{
//		log.info("EmpDetailsController path variable: Employee ID "+id);
//		boolean result = false;
//		result = empDetailsService.checkEmployeeExists(id);
//		log.info("EmpDetailsController validateEmployee result" + result);
//		return result;
//	}
	
	@RequestMapping(value = "/employees",method = RequestMethod.GET)
	public List<EmployeeDetails> getAllEmployees() throws Exception{
		log.info("EmpDetailsController getAllEmployees ");
		List<EmployeeDetails> emplList = new ArrayList<EmployeeDetails>();
		emplList = empDetailsService.getAllEmployees();
		log.info("EmpDetailsController getAllEmployees List:: " + emplList);
		if(null!= emplList){
			log.info("EmpDetailsController getAllEmployees result" + emplList.toString());
		}
		return emplList;
	}
	
	@RequestMapping(value = "/employees/{empId}",method = RequestMethod.DELETE)
	public String deleteEmployee(@PathVariable ("empId") long id) throws Exception{
		log.info("EmpDetailsController deleteEmployee: Employee ID "+id);
		String result = "false";
		result = empDetailsService.deleteEmployeeDetails(id);
		log.info("EmpDetailsController deleteEmployee result" + result);
		return result;
	}
}

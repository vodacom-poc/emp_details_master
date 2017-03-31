/**
 * 
 */
package com.accenture.microservices.emp.details;

import java.util.ArrayList;
import java.util.List;

import com.accenture.lari.employees.domain.EmployeeDetails;

/**
 * @author shwet.priya
 *
 */
public class ApplicationTestConstants {

	public static final Long  EMPLOYEE_ID = 1233L;
	
	public static final String FIRST_NAME_HANDLER  = "Unknown";
	
	public static final String SUCCESS  = "true";
	
	public static final String FAILURE  = "Employee Does not Exist. Please provide an existing employee";
	
	public static final EmployeeDetails EMPLOYEE_DETAILS_HANDLER(){
		EmployeeDetails employeeDetails = new EmployeeDetails();
		employeeDetails.setFirstName("Unknown");
		return employeeDetails;
	}
	
	public static final EmployeeDetails EMPLOYEE_DETAILS_SAVE(){
		EmployeeDetails employeeDetails = new EmployeeDetails();
		employeeDetails.setId(1111);
		return employeeDetails;
	}
	
	public static final List<EmployeeDetails> createEmployeeObjectList(){
		List<EmployeeDetails> allEmployeeList = new ArrayList<>();
		EmployeeDetails employee1 = new EmployeeDetails("Jakie", "Ezu", 21, "bangalore", "jakie.ezu@gmail.com", 13333);
		EmployeeDetails employee2 = new EmployeeDetails("Ann", "Jee", 34, "Chennai", "ann.jeeu@gmail.com", 1233);
		EmployeeDetails employee3 = new EmployeeDetails("Bann", "Hee", 36, "Hydrabad", "bann.hee@gmail.com", 123456);
		EmployeeDetails employee4 = new EmployeeDetails("Cann", "lee", 25, "Mumbai", "cann.lee@gmail.com", 1245);
		EmployeeDetails employee5 = new EmployeeDetails("Dann", "lee", 28, "Delhi", "dann.lee@gmail.com", 12354);
		EmployeeDetails employee6 = new EmployeeDetails("Kann", "Mde", 45, "Kolkata", "kann.mde@gmail.com", 1262);
		EmployeeDetails employee7 = new EmployeeDetails("Zann", "Nke", 53, "Cochin", "zann.nke@gmail.com", 1263);
		allEmployeeList.add(employee1);
		allEmployeeList.add(employee2);
		allEmployeeList.add(employee3);
		allEmployeeList.add(employee4);
		allEmployeeList.add(employee5);
		allEmployeeList.add(employee6);
		allEmployeeList.add(employee7);
		return allEmployeeList;
		
	}
	
	public static final EmployeeDetails EMPLOYEE_DETAILS = new EmployeeDetails("Ann", "Jee", 34, "Chennai", "ann.jeeu@gmail.com", 1233);
	
}

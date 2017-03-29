package com.accenture.microservices.emp.details.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.accenture.lari.employees.domain.EmployeeDetails;
import com.accenture.lari.employees.repository.EmployeeRepository;
import com.accenture.lari.employees.service.impl.EmpDetailsServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EmpDetailsServiceImpl.class)
public class EmployeeServiceTest {
	public static final Logger log = LoggerFactory.getLogger(EmployeeServiceTest.class);
	@Autowired
	EmpDetailsServiceImpl empDetailsService;
	
	@MockBean
	EmployeeRepository employeeRepository;

	@Test
	public void validateChargeCode() throws Exception {
	List<EmployeeDetails> allEmployeeRefList = createEmployeeObjectList();		
		given(this.empDetailsService.getAllEmployees()).willReturn(allEmployeeRefList);
		Collection<EmployeeDetails> allEmployeesList = this.empDetailsService.getAllEmployees();
		log.info("from service layer: "+allEmployeesList.toString());
		log.info("reference object: "+allEmployeeRefList.toString());
		Collection<EmployeeDetails> newComapreObject=new ArrayList<EmployeeDetails>();
		newComapreObject.addAll(allEmployeeRefList);
		assertThat(newComapreObject.equals(allEmployeesList));
	}
	
	public List<EmployeeDetails> createEmployeeObjectList(){
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

}

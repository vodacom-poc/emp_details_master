/**
 * 
 */
package com.accenture.microservices.emp.details.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.Arrays;
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
import com.accenture.lari.employees.repository.EmployeeDetailsRepository;
import com.accenture.lari.employees.service.impl.EmpDetailsServiceImpl;
import com.accenture.microservices.emp.details.ApplicationTestConstants;

/**
 * @author shwet.priya
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = EmpDetailsServiceImpl.class)
public class EmpDetailsServiceImplTest {
	public static final Logger log = LoggerFactory.getLogger(EmpDetailsServiceImplTest.class);
	
	@Autowired
	EmpDetailsServiceImpl empDetailsService;
	
	@MockBean
	EmployeeDetailsRepository employeeRepository;

	/**
	 * Test method for {@link com.accenture.lari.employees.service.impl.EmpDetailsServiceImpl#getEmployeeDetails(long)}.
	 */
	@Test
	public void testGetEmployeeDetails()throws Exception {
		given(this.empDetailsService.getEmployeeDetails(ApplicationTestConstants.EMPLOYEE_ID)).willReturn(ApplicationTestConstants.EMPLOYEE_DETAILS);
		EmployeeDetails employeeDetails =this.empDetailsService.getEmployeeDetails(ApplicationTestConstants.EMPLOYEE_ID);
		log.info("from service layer EmpDetailsServiceImplTest class - testGetEmployeeDetails(): " + employeeDetails.toString());
		assertThat(employeeDetails.getId()).isEqualTo(ApplicationTestConstants.EMPLOYEE_ID);
	}
	/**
	 * Test method for {@link com.accenture.lari.employees.service.impl.EmpDetailsServiceImpl#handleEmployeeDetails(long, java.lang.Throwable)}.
	 */
	@Test
	public void testHandleEmployeeDetails() {
		//given(this.empDetailsService.handleEmployeeDetails(ApplicationTestConstants.EMPLOYEE_ID,null)).willReturn(ApplicationTestConstants.EMPLOYEE_DETAILS_HANDLER());
		EmployeeDetails employeeDetails =this.empDetailsService.handleEmployeeDetails(ApplicationTestConstants.EMPLOYEE_ID, null);
		log.info("from service layer EmpDetailsServiceImplTest class - testHandleEmployeeDetails(): " + employeeDetails.toString());
		assertThat(employeeDetails.getFirstName()).isEqualTo(ApplicationTestConstants.FIRST_NAME_HANDLER);
	}

	/**
	 * Test method for {@link com.accenture.lari.employees.service.impl.EmpDetailsServiceImpl#checkEmployeeExists(long)}.
	 */
	@Test
	public void testCheckEmployeeExists() throws Exception{
		given(this.empDetailsService.checkEmployeeExists(ApplicationTestConstants.EMPLOYEE_ID)).willReturn(true);
		Boolean result =this.empDetailsService.checkEmployeeExists(ApplicationTestConstants.EMPLOYEE_ID);
		log.info("from service layer EmpDetailsServiceImplTest class - testCheckEmployeeExists(): " + result);
		assertThat(result).isEqualTo(true);
	}

	/**
	 * Test method for {@link com.accenture.lari.employees.service.impl.EmpDetailsServiceImpl#getAllEmployees()}.
	 */
	@Test
	public void testGetAllEmployees() throws Exception {
		List<EmployeeDetails> allEmployeeRefList = ApplicationTestConstants.createEmployeeObjectList();		
		given(this.empDetailsService.getAllEmployees()).willReturn(allEmployeeRefList);
		Collection<EmployeeDetails> allEmployeesList = this.empDetailsService.getAllEmployees();
		log.info("from service layer EmpDetailsServiceImplTest class - testGetAllEmployees(): "+allEmployeesList.toString());
		log.info("reference object: "+allEmployeeRefList.toString());
		Collection<EmployeeDetails> newComapreObject=new ArrayList<EmployeeDetails>();
		newComapreObject.addAll(allEmployeeRefList);
		assertThat(newComapreObject.equals(allEmployeesList));
	}

	/**
	 * Test method for {@link com.accenture.lari.employees.service.impl.EmpDetailsServiceImpl#handleGetAllEmployees(java.lang.Throwable)}.
	 */
	@Test
	public void testHandleGetAllEmployees() {
		List<EmployeeDetails> employeeDetails =this.empDetailsService.handleGetAllEmployees(null);
		log.info("from service layer EmpDetailsServiceImplTest class - testHandleGetAllEmployees(): " + employeeDetails.toString());
		assertThat(employeeDetails.get(0).getId()).isEqualTo(Arrays.asList(new EmployeeDetails()).get(0).getId());
	}

	/**
	 * Test method for {@link com.accenture.lari.employees.service.impl.EmpDetailsServiceImpl#deleteEmployeeDetails(long)}.
	 */
	@Test
	public void testDeleteEmployeeDetailsSuccess() throws Exception {
		employeeRepository.save(ApplicationTestConstants.EMPLOYEE_DETAILS_SAVE());
		String result =this.empDetailsService.deleteEmployeeDetails(ApplicationTestConstants.EMPLOYEE_DETAILS_SAVE().getId());
		log.info("from service layer EmpDetailsServiceImplTest class - testDeleteEmployeeDetailsSuccess(): " + result);
		assertThat(result.equals(ApplicationTestConstants.SUCCESS));
	}
	
	/**
	 * Test method for {@link com.accenture.lari.employees.service.impl.EmpDetailsServiceImpl#deleteEmployeeDetails(long)}.
	 */
	@Test
	public void testDeleteEmployeeDetailsFailure() throws Exception{
		String result =this.empDetailsService.deleteEmployeeDetails(ApplicationTestConstants.EMPLOYEE_ID);
		log.info("from service layer EmpDetailsServiceImplTest class - testDeleteEmployeeDetailsFailure(): " + result);
		assertThat(result.equals(ApplicationTestConstants.FAILURE));
	}

}
package com.accenture.microservices.emp.details.pact;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.TestContextManager;

import com.accenture.lari.employees.EmpDetailsMasterApplication;
import com.accenture.lari.employees.domain.EmployeeDetails;
import com.accenture.lari.employees.repository.EmployeeDetailsRepository;

import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.TestTarget;



@Profile("pact_test")

@RunWith(PactRunner.class)
@Provider("employeedetails")
@PactFolder(EmpDetailsApplicationConstants.pactFolder)

@SpringBootTest(
  classes = EmpDetailsMasterApplication.class,
  webEnvironment=SpringBootTest.WebEnvironment.DEFINED_PORT,
  properties = {"server.port=8080"}
)

public class ProviderPactTest {
	
	@Autowired
	private EmployeeDetailsRepository employeeDetailsRepository;
	
	

    @TestTarget
    public final HttpTarget target = new HttpTarget(8080);


    @Before
    public void beforeClass() throws Exception {
    	
    	 new TestContextManager(getClass()).prepareTestInstance(this);
    		
    }
    
    
    @State("given employee exists for employee id 1233 exists")	
    public void toDefaultState() {
    	
    	  	
    	EmployeeDetails employeeDetails =generateEmployeeEnity();
    	employeeDetailsRepository.save(employeeDetails);
    	

    }
    public EmployeeDetails generateEmployeeEnity(){
		   EmployeeDetails employeeDetails = new EmployeeDetails();
		   employeeDetails.setId(1233);
		   employeeDetails.setFirstName("Zann");
		   employeeDetails.setLastName("Nke");
		   employeeDetails.setAge(53);
		   employeeDetails.setAddress("Cochin");
		   employeeDetails.setEmail("zann.nke@gmail.com");
		   
		   return employeeDetails;
	   }

}
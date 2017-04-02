package com.accenture.microservices.emp.details;


import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.accenture.lari.employees.EmpDetailsMasterApplication;
import com.accenture.lari.employees.domain.EmployeeDetails;


@SpringBootTest (classes = EmpDetailsMasterApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class EmpDetailsMasterApplicationTests{

public static final Logger log = LoggerFactory.getLogger(EmpDetailsMasterApplicationTests.class);

/*@Autowired
private SetterMessage message = null;*/
	
	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));
	
	private MockMvc mockMvc;
    
    //  private HttpMessageConverter mappingJackson2HttpMessageConverter;
    
	@Autowired
    private WebApplicationContext webApplicationContext;
	
	
    
    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }
	
    /**
     * 
     * @throws Exception
     * @Description: positive test case- Unit test with parameter employeeId
     * @param: employeeId
     * @return: EmployeeDetails
     * @expected result: EmployeeDetails document
     * 
     */
	@Test
	public void getEmployeeDetails() throws Exception {
		List<EmployeeDetails> allEmployeeRefList = createEmployeeObjectList();
		MvcResult allEmployeesList = mockMvc.perform(get("/employees")).andDo(print()).andReturn();
		Collection<EmployeeDetails> newComapreObject=new ArrayList<EmployeeDetails>();
		newComapreObject.addAll(allEmployeeRefList);
		log.info("All employees list");
		assertThat(newComapreObject.equals(allEmployeesList));
	}
	
	/**
     * 
     * @throws Exception
     * @Description: positive test case- Unit test with parameter employeeId
     * @param: employeeId
     * @return: EmployeeDetails
     * @expected result: EmployeeDetails document
     */
     
	
	@Test
	public  void getEmployee() throws Exception {
		List<EmployeeDetails> Employee = createEmployeeObjectList();
		MvcResult allEmployeesList = mockMvc.perform(get("/employees/1233")).andDo(print()).andReturn();
		Collection<EmployeeDetails> newComapreObject=new ArrayList<EmployeeDetails>();
		newComapreObject.addAll(Employee);
		assertThat(newComapreObject.equals(allEmployeesList));
		log.info("employee number:1233");
	}
	
	/**
	@Test
	public void testMessage()
	{
		assertNotNull("Constructor message instance is null ", message);
		String msg = ((Throwable) message).getMessage();
		assertNotNull("Message is null.",msg);
		String  expectedMessage = "Employee details should not be null";
		assertEquals("Message shuld be '"+expectedMessage + "'.", expectedMessage,msg);
		log.info("message='{}'",msg); 
	}*/
	
	@Test
    public void EMployeeNotFound() throws Exception {
		MvcResult allEmployeesList = mockMvc.perform(get("/employees")).andDo(print()).andReturn();
		log.info("Employee not found");
               
    }
	
	
	@Test
	public void test_get_all_success() throws Exception {
	   	    mockMvc.perform(get("/employees"))
	            .andExpect(status().isOk())
	            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
	              	}

	
	/**@Test
	public void test_create_employees_fail_404_not_found() throws Exception {
	    
	    mockMvc.perform(get("/employees"))
	    .andExpect(status().isNotFound())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));  
	    log.info("Bad Exception");
	   	}*/
	
	
	

	/**
	public static void fail(String message) {
		throw new AssertionError(message);
	}*/

		
	/**
	 * 
	 * @return Employee lIst generator method
	 */
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

		
	/**
	 * 
	 * @throws Exception
	 * @Description: positive test case- Unit Test with out employeeId
	 * @param: null
     * @return: EmployeeDetails arraylist
     * @expected result: arraylist of EmployeeDetails  document 
	 */
	 
	 
	@Test
	public void getAllEmployees() throws Exception {
		log.info(" Inside getAllEmployees");
	List<EmployeeDetails> emplList = new ArrayList<EmployeeDetails>();
		mockMvc.perform(get("/employees")).andExpect(status().isOk()).andDo(print()).andExpect(content().contentType(contentType));
	}
	
	/**
     * 
     * @throws Exception
     * @Description: negative test case- Unit test with parameter employeeId
     * @param: employeeId
     * @return: null
     * @expected result: 404 
     *
     
     
	
	@Test
	public void getEmployeeDetailsURLCheck() throws Exception {
		log.info(" Inside getEmployeeDetailsURLCheck");
		int employeeId = 1233;
		mockMvc.perform(get("/employees/Details/"+employeeId)).andExpect(status().isNotFound()).andDo(print());
		
	}
	
	 *//**
     * 
     * @throws Exception
     * @Description: positive test case- Unit test with parameter employeeId
     * @param: employeeId
     * @return: true
     * @expected result: Employee Does not Exist. Please provide an existing employee
     * 
     */
	
	@Test
	public void deleteEmployeeDetails() throws Exception {
		MvcResult result = mockMvc.perform(delete("/employees/12331")).andDo(print()).andReturn();
		log.info(result.getResponse().getContentAsString());
	}
	
	/*
	 *//**
     * 
     * @throws Exception
     * @Description: negative test case- Unit test with parameter employeeId
     * @param: employeeId
     * @return: false
     * @expected result: false
     * 
     */
     
     
	@Test
	public void deleteEmployee() throws Exception {
		MvcResult result = mockMvc.perform(delete("/employees/1233")).andDo(print()).andReturn();
		log.info(result.getResponse().getContentAsString());
	}

}
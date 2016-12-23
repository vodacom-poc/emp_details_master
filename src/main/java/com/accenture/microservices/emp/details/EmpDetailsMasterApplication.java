package com.accenture.microservices.emp.details;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.accenture.microservices.emp.details.data.EmployeeDetails;
import com.accenture.microservices.emp.details.data.repository.EmployeeRepository;

@SpringBootApplication(scanBasePackages = {"com.accenture.microservices"})
public class EmpDetailsMasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpDetailsMasterApplication.class, args);
	}
	private static final Logger log = LoggerFactory.getLogger(EmpDetailsMasterApplication.class);

		  @Bean
		public CommandLineRunner demo(EmployeeRepository repository){
	    	return (args) ->{
	    		repository.save(new EmployeeDetails("Jakie", "Ezu", 21, "bangalore", "jakie.ezu@gmail.com", 1233));
	    		repository.save(new EmployeeDetails("Ann", "Jee", 34, "Chennai", "ann.jeeu@gmail.com", 1234));
	    		repository.save(new EmployeeDetails("Bann", "Hee", 36, "Hydrabad", "bann.hee@gmail.com", 1235));
	    		repository.save(new EmployeeDetails("Cann", "lee", 25, "Mumbai", "cann.lee@gmail.com", 1245));
	    		repository.save(new EmployeeDetails("Dann", "lee", 28, "Delhi", "dann.lee@gmail.com", 1246));
	    		repository.save(new EmployeeDetails("Kann", "Mde", 45, "Kolkata", "kann.mde@gmail.com", 1247));
	    		repository.save(new EmployeeDetails("Zann", "Nke", 53, "Cochin", "zann.nke@gmail.com", 1248));
	    		
	    		log.info("Employees");
	       		for (EmployeeDetails Employee : repository.findAll()) {
	    			log.info(Employee.toString());
	    	}
	     };   	
	    }
}

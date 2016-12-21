package com.accenture.microservices.emp.details;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmpDetailsMasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpDetailsMasterApplication.class, args);
	}
	private static final Logger log = LoggerFactory.getLogger(EmpDetailsMasterApplication.class);
	  @Bean
		public CommandLineRunner demo(EmployeeRepository repository){
	    	return (args) ->{
	    		repository.save(new Employee("Jakie", "Ezu", 21, "bangalore", "jakie.ezu@gmail.com", 10));
	    		repository.save(new Employee("Ann", "Jee", 34, "Chennai", "ann.jeeu@gmail.com", 11));
	    		repository.save(new Employee("Bann", "Hee", 36, "Hydrabad", "bann.hee@gmail.com", 12));
	    		repository.save(new Employee("Cann", "lee", 25, "Mumbai", "cann.lee@gmail.com", 13));
	    		repository.save(new Employee("Dann", "lee", 28, "Delhi", "dann.lee@gmail.com", 14));
	    		repository.save(new Employee("Kann", "Mde", 45, "Kolkata", "kann.mde@gmail.com", 15));
	    		repository.save(new Employee("Zann", "Nke", 53, "Cochin", "zann.nke@gmail.com", 16));
	    		
	    		log.info("Employees");
	       		for (Employee Employee : repository.findAll()) {
	    			log.info(Employee.toString());
	    	}
	     };   	
	    }
}

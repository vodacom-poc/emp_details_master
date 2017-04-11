/**
 * 
 */
package com.accenture.lari.employees.repository;

import java.util.List;

import org.springframework.data.couchbase.core.query.View;
import org.springframework.data.repository.CrudRepository;

import com.accenture.lari.employees.domain.EmployeeDetails;

/**
 * @author j.venugopalan
 *
 */
/*public interface EmployeeDetailsRepository extends JpaRepository<EmployeeDetails, Long>{
	
	public EmployeeDetails findByLastName(String lastName);
	public EmployeeDetails findById(long id);
	public List<EmployeeDetails> findAll();
	public void delete(Long id) ;
	public boolean exists(Long id);
}*/
public interface EmployeeDetailsRepository extends CrudRepository<EmployeeDetails, Long>{
	
	@View(designDocument = "employees", viewName = "byEmployeeId")
	EmployeeDetails findById(long id);

	/*public EmployeeDetails findByLastName(String lastName);
	public EmployeeDetails findById(long id);
	//public List<EmployeeDetails> findAll();
	public void delete(Long id) ;
	public boolean exists(Long id);*/
}
package com.learning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.learning.entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{
	
	public List<Employee> findAll();

	@SuppressWarnings("unchecked")
	public Employee save(Employee employee);

	public Employee findOneByEmpId(long empId);
	
	@Query("select e from Employee e where e.firstName=:fName")
	public List<Employee> findByEmpByName(@Param("fName")String fName);
		
}

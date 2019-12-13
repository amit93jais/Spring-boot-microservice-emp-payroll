package com.learning.payroll.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.learning.payroll.entity.Payroll;

@Repository
public interface PayrollRepository extends CrudRepository<Payroll, Long>{
	
	@SuppressWarnings("unchecked")
	public Payroll save(Payroll payroll);
	
	public Payroll findOneById(long payrollId);
	
	public List<Payroll> findAll();

	@Query("select p from Payroll p where p.empId IN :empIdList")
	public List<Payroll> findByEmployeeIds(@Param("empIdList")List<Long> empIdList);

}

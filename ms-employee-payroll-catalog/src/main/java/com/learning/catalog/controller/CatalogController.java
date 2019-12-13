package com.learning.catalog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.catalog.service.CatalogService;
import com.learning.dto.EmployeeDto;
import com.learning.dto.EmployeePayrollDto;
import com.learning.dto.PayrollDto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping(value = "/catalog")
public class CatalogController {
	
	private CatalogService catalogService;
	
	@Autowired
	CatalogController(CatalogService catalogService){
		this.catalogService = catalogService;
	}
	
	@PostMapping("/employee")
	public ResponseEntity<Void> createEmployee(@RequestBody EmployeeDto employeeDto) {
		return catalogService.addEmployee(employeeDto);
	}
	
	@GetMapping("/employee/{fName}")
	//@HystrixCommand(fallbackMethod = "fallbackMethod")
	public List<EmployeePayrollDto> getEmployeePayrollDetailsByName(@PathVariable(value = "fName") String fName) {
		return catalogService.getEmployeePayrollDetailsByName(fName);
	}
	
	@GetMapping("/payroll/{empIds}")
	public List<PayrollDto> getPayrollDetailsByName(@PathVariable(value = "empIds") List<Long> empIds) {
		return catalogService.getPayrollDetailsByEmpIds(empIds);
	}
	
	public String fallbackMethod(String fName) {
		return "Fallback response:: No employee details available temporarily";
	}
	
	
}

package com.learning.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.dto.EmployeeDto;
import com.learning.services.EmployeeServices;

@RestController
@RequestMapping(value="/employee")
public class EmployeeController {
	
	private EmployeeServices employeeServices;
	
	@Autowired
	EmployeeController(EmployeeServices employeeServices) {
		this.employeeServices = employeeServices;
	}
	
	@PostMapping
	public ResponseEntity<Void> addEmployee(@RequestBody EmployeeDto employee) {
		employeeServices.addEmployee(employee);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping
	public List<EmployeeDto> getAllEmployees(){
		return employeeServices.getAllEmployees();
	}
	
	@GetMapping("/{empId}")
	public EmployeeDto getEmployeeById(@PathVariable(value = "empId") long empId) {
		return employeeServices.getEmployeeById(empId);
	}
	
	@GetMapping("/name/{fName}")
	public List<EmployeeDto> findEmployeeByName(@PathVariable(value = "fName") String fName) {
		return employeeServices.getEmployeeByName(fName);
		
	}
	
}

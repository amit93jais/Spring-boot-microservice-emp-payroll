package com.learning.catalog.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.learning.catalog.client.EmployeeClient;
import com.learning.catalog.client.PayrollClient;
import com.learning.dto.EmployeeDto;
import com.learning.dto.EmployeePayrollDto;
import com.learning.dto.PayrollDto;

@Service
public class CatalogService {

	EmployeeClient employeeClient;

	PayrollClient payrollClient;

	@Autowired
	CatalogService(EmployeeClient employeeClient, PayrollClient payrollClient) {
		this.employeeClient = employeeClient;
		this.payrollClient = payrollClient;
	}

	public ResponseEntity<Void> addEmployee(EmployeeDto employeeDto) {
		employeeClient.addEmployee(employeeDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
	private List<EmployeePayrollDto> getEmployeePayrollDtos(List<EmployeeDto> employeeDtos, List<PayrollDto> payrollDtos){
		List<EmployeePayrollDto> employeePayrollDtos = new ArrayList<>();
		for(int i=0; i<employeeDtos.size();i++) {
			EmployeePayrollDto employeePayrollDto = new EmployeePayrollDto();
			//Setting Employee properties
			employeePayrollDto.setEmpid(employeeDtos.get(i).getEmpId());
			employeePayrollDto.setFirstName(employeeDtos.get(i).getFirstName());
			employeePayrollDto.setLastName(employeeDtos.get(i).getLastName());
			employeePayrollDto.setAddress(employeeDtos.get(i).getAddress());
			employeePayrollDto.setDesignation(employeeDtos.get(i).getDesignation());
			employeePayrollDto.setJoiningDate(employeeDtos.get(i).getJoiningDate());
			employeePayrollDto.setDepartment(employeeDtos.get(i).getDepartment());
			//Setting Payroll details
			employeePayrollDto.setCtc(payrollDtos.get(i).getCtc());
			employeePayrollDtos.add(employeePayrollDto);
		}
		return employeePayrollDtos;
	}

	public List<EmployeePayrollDto> getEmployeePayrollDetailsByName(String fName) {
		List<EmployeeDto> employeeDtos = employeeClient.getEmpByName(fName);
		System.out.println("***************** "+employeeDtos.get(0).getFirstName());
		List<Long> empIds = employeeDtos.stream().map(EmployeeDto::getEmpId).collect(Collectors.toList());
		List<PayrollDto> payrollDtos = payrollClient.getPayrollDetailsByEmpId(empIds);
		System.out.println("***************** "+payrollDtos.get(0).getEmpId());
		List<EmployeePayrollDto> empPayrollDtos = getEmployeePayrollDtos(employeeDtos, payrollDtos);
		return empPayrollDtos;
	}
	
	public List<PayrollDto> getPayrollDetailsByEmpIds(List<Long> empIds) {
		return payrollClient.getPayrollDetailsByEmpId(empIds);
	}

}

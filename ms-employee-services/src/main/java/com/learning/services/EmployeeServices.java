package com.learning.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.dto.EmployeeDto;
import com.learning.entity.Employee;
import com.learning.repository.EmployeeRepository;

@Service
public class EmployeeServices {
	
    private EmployeeRepository employeeRepository;
	
	@Autowired
	EmployeeServices(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	public void addEmployee(EmployeeDto employeeDto) {
		Employee employee = new Employee();
		BeanUtils.copyProperties(employeeDto, employee);
		employeeRepository.save(employee);
	}

	public List<EmployeeDto> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		return getEmployeeDtos(employees);
	}

	public EmployeeDto getEmployeeById(long empId) {
		Employee employee = employeeRepository.findOneByEmpId(empId);
		EmployeeDto employeeDto = new EmployeeDto();
		BeanUtils.copyProperties(employee, employeeDto);
		return employeeDto;
	}

	public List<EmployeeDto> getEmployeeByName(String fName) {
		List<Employee> employees = employeeRepository.findByEmpByName(fName);
		return getEmployeeDtos(employees);
	}
	
	private List<EmployeeDto> getEmployeeDtos(List<Employee> employees){
		List<EmployeeDto> employeeDtos = new ArrayList<>();
		for (Employee employee : employees) {
			EmployeeDto employeeDto = new EmployeeDto();
			BeanUtils.copyProperties(employee, employeeDto);
			employeeDtos.add(employeeDto);
		}
		return employeeDtos;
	}

}

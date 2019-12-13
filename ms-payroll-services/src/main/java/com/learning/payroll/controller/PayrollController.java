package com.learning.payroll.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learning.dto.PayrollDto;
import com.learning.payroll.service.PayrollService;

@RestController
@RequestMapping(value = "/payroll")
public class PayrollController {
	
	private PayrollService payrollService;
	
	@Autowired
	public PayrollController(PayrollService payrollService) {
		this.payrollService = payrollService;
	}

	@RequestMapping(value = "" ,method=RequestMethod.POST,headers = {"content-type=application/json"})
	public void addPayrollDetails(@RequestBody PayrollDto payrollDto) {
		payrollService.addPayrollDetails(payrollDto);

	}

	@GetMapping("/all")
	public List<PayrollDto> findAllPayrollDetails() {
		return payrollService.geAllPayrollInfos();
	}
	
	@GetMapping("/{empIds}")
	public List<PayrollDto> getPayrollDetailsByEmpId(@PathVariable(value="empIds") List<Long> empIds){
		return payrollService.findPayrollDetailsByEmpId(empIds);
	}
	
}

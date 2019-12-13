package com.learning.payroll.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.dto.PayrollDto;
import com.learning.payroll.entity.Payroll;
import com.learning.payroll.repository.PayrollRepository;

@Service
public class PayrollService {
	
	private PayrollRepository payrollRepository;
	
	@Autowired
	public PayrollService(PayrollRepository payrollRepository) {
		this.payrollRepository = payrollRepository;
	}

	public void addPayrollDetails(PayrollDto payrollDto) {
		Payroll payroll = new Payroll();
		BeanUtils.copyProperties(payrollDto, payroll);
		payrollRepository.save(payroll);
	}

	public PayrollDto getPayrollInfoById(long payrollId) {
		Payroll payroll = payrollRepository.findOneById(payrollId);
		PayrollDto payrollDto = new PayrollDto();
		BeanUtils.copyProperties(payroll, payrollDto);
		return payrollDto;
	}

	public List<PayrollDto> geAllPayrollInfos() {
		return getPayrollDtos(payrollRepository.findAll());
	}
	
	private List<PayrollDto> getPayrollDtos(List<Payroll> Payrolls){
		List<PayrollDto> payrollDtos = new ArrayList<>();
		for (Payroll Payroll : Payrolls) {
			PayrollDto payrollDto = new PayrollDto();
			BeanUtils.copyProperties(Payroll, payrollDto);
			payrollDtos.add(payrollDto);
		}
		return payrollDtos;
	}

	public List<PayrollDto> findPayrollDetailsByEmpId(List<Long> empIds) {
		List<Payroll> payrolls = payrollRepository.findByEmployeeIds(empIds);
		List<PayrollDto> payrollDtos = new ArrayList<>();
		for (Payroll Payroll : payrolls) {
			PayrollDto payrollDto = new PayrollDto();
			BeanUtils.copyProperties(Payroll, payrollDto);
			payrollDtos.add(payrollDto);
		}
		return payrollDtos;
	}

}

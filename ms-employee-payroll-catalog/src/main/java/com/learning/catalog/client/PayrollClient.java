package com.learning.catalog.client;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.learning.dto.PayrollDto;


@FeignClient("ms-payroll-services")
@RibbonClient("ms-payroll-services")
public interface PayrollClient {
	
	@RequestMapping(value="/payroll/{empIds}",method= RequestMethod.GET)
	public List<PayrollDto> getPayrollDetailsByEmpId(@PathVariable(value="empIds") List<Long> empIds);

}

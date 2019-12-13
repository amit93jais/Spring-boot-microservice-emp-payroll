package com.learning.catalog.client;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.learning.dto.EmployeeDto;

@FeignClient("ms-employee-services")
@RibbonClient("ms-employee-services")
public interface EmployeeClient {
	
	@RequestMapping(value = "/employee" ,method=RequestMethod.POST, headers = {"content-type=application/json"})
	public void addEmployee(@RequestBody EmployeeDto employeeDto);
	
	@RequestMapping(value = "/employee/name/{fName}" ,method=RequestMethod.GET, headers = {"content-type=application/json"})
	public List<EmployeeDto> getEmpByName(@PathVariable(value = "fName") String fName);

}

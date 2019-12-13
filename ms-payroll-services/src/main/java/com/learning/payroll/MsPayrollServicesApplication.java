package com.learning.payroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsPayrollServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsPayrollServicesApplication.class, args);
	}

}

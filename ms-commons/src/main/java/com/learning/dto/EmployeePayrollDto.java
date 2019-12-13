package com.learning.dto;

public class EmployeePayrollDto {
	
	private long empId;
	private String firstName;
	private String lastName;
	private String designation;
	private String department;
	private String address;
	private String joiningDate;
	private long ctc;
	private String additionalDetails;
	
	public long getCtc() {
		return ctc;
	}
	public void setCtc(long ctc) {
		this.ctc = ctc;
	}
	public String getAdditionalDetails() {
		return additionalDetails;
	}
	public void setAdditionalDetails(String additionalDetails) {
		this.additionalDetails = additionalDetails;
	}
	public long getEmpId() {
		return empId;
	}
	public void setEmpid(long empId) {
		this.empId = empId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}

}

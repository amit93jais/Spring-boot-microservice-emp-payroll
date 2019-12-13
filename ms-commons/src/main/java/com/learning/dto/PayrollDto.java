package com.learning.dto;

public class PayrollDto {

	private long id;

	private long ctc;

	private String additionalDetails;
	
	private long empId; 

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


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

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	
}

package com.sgeneral.employee.model;

import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="All details of the user")
public class Employee implements Comparable<Employee> {

	@Size(min=1,message="First Name length should be greater than 1")
	@ApiModelProperty(notes ="Employee First Name")
	private String firstName;
	
	@ApiModelProperty(notes ="Employee Last Name")
	private String lastName;
	
	@ApiModelProperty(notes ="Employee Gender")
	private String gender;
	
	@ApiModelProperty(notes ="Employee Date of Birth")

	private String dateOfBirth;
	
	@ApiModelProperty(notes ="Employee Department")

	private String department;
	
	
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	
	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", dateOfBirth="
				+ dateOfBirth + ", department=" + department + "]";
	}
	@Override
	public int compareTo(Employee o) {
		
		return this.firstName.compareTo(o.firstName);
	}
	
	
	
	
	
}


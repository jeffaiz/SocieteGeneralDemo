package com.sgeneral.employee.model;

public class Employee implements Comparable<Employee> {

	private String firstName;
	private String lastName;
	private String gender;
	
	private String dateOfBirth;
	
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
				+ dateOfBirth + "]";
	}
	@Override
	public int compareTo(Employee o) {
		
		return this.firstName.compareTo(o.firstName);
	}
	
	
	
	
	
}


package com.sgeneral.employee.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sgeneral.employee.model.Employee;


@Component
public class EmployeeService {
	
	private List<Employee> employeeList=new ArrayList();

	
	public void createEmployee(Employee emp) {
		employeeList.add(emp);	
	}
	
	public List<Employee> getEmployeeList(){
		Collections.sort(employeeList);
		return employeeList;
		
	}

}

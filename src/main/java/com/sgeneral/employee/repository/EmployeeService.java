package com.sgeneral.employee.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.sgeneral.employee.model.Employee;


@Service
public class EmployeeService {
	
	private List<Employee> employeeList=new ArrayList();

	
	public void createEmployee(Employee emp) {
		emp.setFirstName(emp.getFirstName().toLowerCase());
		employeeList.add(emp);	
	}
	
	public List<Employee> getEmployeeList(){
		Collections.sort(employeeList);
		return employeeList;
		
	}

}

package com.sgeneral.employee;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.sgeneral.employee.controller.EmployeeController;
import com.sgeneral.employee.model.Employee;
import com.sgeneral.employee.repository.EmployeeService;

@SpringBootTest
public class EmployeeServiceTest {
	@Mock
	EmployeeService employeeService;

	@InjectMocks
	EmployeeController employeeController;
	
	@Test
	void contextLoads() {
	}

	@Test
	public void testGetAllEmployeeList() {
		List<Employee> employeeList=new ArrayList();
		employeeList.add(new Employee("Faizal", "Jaffri", "Male", "15-03-1993", "CS"));
		employeeList.add(new Employee("Bharathan", "Bhoomi", "Male", "25-06-1992", "ECE"));
		when(employeeService.getEmployeeList()).
		thenReturn(employeeList);
		assertEquals(2, employeeController.retrieveAllUsers().size());
		
	}
}

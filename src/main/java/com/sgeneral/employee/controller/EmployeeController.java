package com.sgeneral.employee.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgeneral.employee.model.Employee;
import com.sgeneral.employee.repository.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping(path = "/api/v1/employee")
	public ResponseEntity<Employee> createUser(@Valid @RequestBody Employee employee) {

		employeeService.createEmployee(employee);

		return new ResponseEntity<>(employee, HttpStatus.CREATED);

	}

	@GetMapping(path = "/api/v1/employees")
	public List<Employee> retrieveAllUsers() {
		return employeeService.getEmployeeList();

	}

}

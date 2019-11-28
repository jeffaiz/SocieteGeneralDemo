package com.sgeneral.employee.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.CollectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.util.StringUtils;
import com.sgeneral.employee.exception.ItemNotFoundException;
import com.sgeneral.employee.model.Employee;
import com.sgeneral.employee.repository.EmployeeService;

@RestController
public class EmployeeController {

	Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	@PostMapping(path = "/api/v1/employee")
	public ResponseEntity<Employee> createUser(@Valid @RequestBody Employee employee) {
		logger.info("Inside EmployeeController: createUser() method started ");

		if (StringUtils.isEmpty(employee.getFirstName()) || StringUtils.isEmpty(employee.getLastName())
				|| StringUtils.isEmpty(employee.getGender()) || StringUtils.isEmpty(employee.getDateOfBirth())
				|| StringUtils.isEmpty(employee.getDateOfBirth()) || StringUtils.isEmpty(employee.getDepartment())) {
			logger.error("Inside EmployeeController: createUser() method: Missing Attributes in Request Body  ");

			throw new ItemNotFoundException("Please enter all employee details" + " " + employee);

		}
		employeeService.createEmployee(employee);

		logger.info("Inside EmployeeController: createUser method ended ");

		return new ResponseEntity<>(employee, HttpStatus.CREATED);

	}

	@GetMapping(path = "/api/v1/employees")
	public List<Employee> retrieveAllUsers() {
		logger.info("Inside EmployeeController: retrieveAllUsers() method started ");
		List<Employee> employeeList = employeeService.getEmployeeList();
		logger.info("Inside EmployeeController: retrieveAllUsers() method ended ");

		return employeeList;

	}

}

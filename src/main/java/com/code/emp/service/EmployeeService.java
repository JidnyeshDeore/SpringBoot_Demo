package com.code.emp.service;

import java.util.List;

import com.code.emp.entity.Employee;
import com.code.emp.exception.EmployeeNotFoundException;

public interface EmployeeService {

	Object addEmployee(Employee employee);

	List<Employee> getAllEmployee();

	Employee getEmployeeByID(Long id) throws EmployeeNotFoundException;

	void deleteEmployeeById(Long id) throws EmployeeNotFoundException;

	Employee updateEmployee(Employee newEmployee, Long id) throws EmployeeNotFoundException;
	
}

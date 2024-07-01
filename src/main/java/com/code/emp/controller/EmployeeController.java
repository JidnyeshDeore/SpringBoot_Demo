package com.code.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.emp.entity.Employee;
import com.code.emp.exception.EmployeeNotFoundException;
import com.code.emp.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

//	public EmployeeController(EmployeeService employeeService) {
//		super();
//		this.employeeService = employeeService;
//	}
	
	
	@PostMapping("/addEmployee")
	public String addEmployee(@RequestBody Employee employee) {
		 employeeService.addEmployee(employee);
		 return "Employee Added Successfully";
	}
	
	@GetMapping("/getAllEmployee")
	public List<Employee> getAllEmployee(){
		return employeeService.getAllEmployee();
	}
	
	@GetMapping("/Employee/{id}")
	public Employee getEmployeeByID(@PathVariable Long id) throws EmployeeNotFoundException {
		return employeeService.getEmployeeByID(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable Long id) throws EmployeeNotFoundException {
		employeeService.deleteEmployeeById(id);
		return "Delete Employee Successfully!!";
	}
	
	@PutMapping("/update/{id}")
	public Employee updateEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) throws EmployeeNotFoundException {
		return employeeService.updateEmployee(newEmployee,id);
	}
}	

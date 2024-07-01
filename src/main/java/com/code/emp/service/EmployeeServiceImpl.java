package com.code.emp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.emp.entity.Employee;
import com.code.emp.exception.EmployeeNotFoundException;
import com.code.emp.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Object addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> list = employeeRepository.findAll();
		return list;
	}

	@Override
	public Employee getEmployeeByID(Long id) throws EmployeeNotFoundException {
		 Optional<Employee> empByID = employeeRepository.findById(id);
		 if(!empByID.isPresent()) {
			 throw new EmployeeNotFoundException("Employee with given"+id+" is Not present",id);
		 }
		 return empByID.get();
	}

	@Override
	public void deleteEmployeeById(Long id) throws EmployeeNotFoundException {
		Optional<Employee> deleteById = employeeRepository.findById(id);
		if(!deleteById.isPresent()) {
			throw new EmployeeNotFoundException("Employee with given"+id+" is Not present",id); 
		}
		 employeeRepository.deleteById(id);
	}

	@Override
	public Employee updateEmployee(Employee newEmployee, Long id) throws EmployeeNotFoundException {
		Optional<Employee> empById = employeeRepository.findById(id);
		if(empById.isPresent()) {
			Employee employee=empById.get();
			employee.setName(newEmployee.getName());
			employee.setEmail(newEmployee.getEmail());
			employee.setSalary(newEmployee.getSalary());
			return employeeRepository.save(employee);
		}
		else {
			throw new EmployeeNotFoundException("Employee noy found", id);
		}
	}
	
	
	
}

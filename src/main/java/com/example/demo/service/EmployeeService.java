package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	private List<Employee> getAllEmployee()
	{
		return employeeRepository.findAll();
	}

	
	private Employee getEmployeeById(int id)
	{
		return employeeRepository.findById(id).get();
	}

	private Employee saveEmployee(Employee employee)
	{
		return employeeRepository.save(employee);
	}
	
	private Employee updateEmployee(Employee employee)
	{
		return employeeRepository.save(employee);
	}
	
	
	private void deleteEmployeeById(int id)
	{
		employeeRepository.deleteById(id);;
	}
	
	
}

package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public String addEmployee(Employee e) {
		try {
			com.example.demo.entites.Employee emp = new com.example.demo.entites.Employee();
			emp.setEmpname(e.getEmpname());
			employeeRepository.saveAndFlush(emp);
			return "added";
			
		}catch (Exception ex) {
			return ex.getMessage();
		}
	}

}

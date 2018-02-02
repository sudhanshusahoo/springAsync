package com.example.demo.controller;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.model.Request;
import com.example.demo.service.AsyncServices;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/jasmine")
public class DatabaseController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private AsyncServices asyncServices;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() throws InterruptedException, ExecutionException {
		Future<String> s = asyncServices.process();
		Future<Long> l = asyncServices.processInt();
		if(!(s.isDone() && l.isDone())) {
			
			return s.get()+" addedd "+l.get();
		}				
		return "Hello Testing";
	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
	public String addEmp() {
		Employee e = new Employee();
		e.setEmpname("Sudhanshu");
		return employeeService.addEmployee(e);
	}

	public String addEmployee(@RequestBody Request<Employee> request) {
		return "added";
	}

}

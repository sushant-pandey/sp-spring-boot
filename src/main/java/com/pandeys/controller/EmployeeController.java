package com.pandeys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pandeys.dao.EmployeeDAO;
import com.pandeys.model.Employee;

@RestController
@RequestMapping("employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@PostMapping(path = "/add")
	public Employee addEmployee(@RequestBody Employee employee) {
		employeeDAO.save(employee);
		return employee;
	}
	
	@GetMapping(path = "/getEmployees")
	public List<Employee> getAllEmployees(){
		return employeeDAO.findAll();
	}
}

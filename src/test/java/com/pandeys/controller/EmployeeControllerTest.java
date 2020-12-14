package com.pandeys.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pandeys.model.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest
class EmployeeControllerTest {

	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext context;
	
	ObjectMapper om = new ObjectMapper();
	
	@BeforeEach
	public void setUp() {
		System.out.println("Inside set up");
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	@Test
	public void addEmployee_PostRequest() throws Exception {
		
		System.out.println("Inside test method");
		Employee emp = new Employee(107, "TestEmp007", "TestCountry007");
		String employee_input = om.writeValueAsString(emp);
		MvcResult result = mockMvc.perform(post("/employee/add").content(employee_input).
				contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
		String emp_str = result.getResponse().getContentAsString();
		Employee resultEmployee = om.readValue(emp_str, Employee.class);
		System.out.println(resultEmployee);
	}
	@Test
	public void addEmployee_GetRequest() throws Exception {
		
		System.out.println("Inside get test method");
		MvcResult result = mockMvc.perform(get("/employee/getEmployees")).
				andExpect(status().isOk()).andReturn();
		String emp_str = result.getResponse().getContentAsString();
//		List<Employee> resultEmployee = om.readValue(emp_str, List<Employee>.class);
		System.out.println(emp_str);
	}
}

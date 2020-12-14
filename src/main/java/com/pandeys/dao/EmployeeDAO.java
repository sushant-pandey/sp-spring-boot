package com.pandeys.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pandeys.model.Employee;

public interface EmployeeDAO extends JpaRepository<Employee, Integer> {

}

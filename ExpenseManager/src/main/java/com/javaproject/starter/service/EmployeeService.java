package com.javaproject.starter.service;

import java.util.List;

import com.javaproject.starter.model.Employee;

public interface EmployeeService {
	public Employee addEmployee(Employee employee); //create
	public List<Employee> getAllEmployee(); // ReadAll
	public Employee updateEmployee(Employee employee);//Update
	public Employee deleteEmployee(long id);//Delete
	public Employee getEmployee(long id);// Read

}

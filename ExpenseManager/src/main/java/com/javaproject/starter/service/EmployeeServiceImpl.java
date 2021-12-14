package com.javaproject.starter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.javaproject.starter.model.Employee;
import com.javaproject.starter.repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository er;
	
	@Override
	public Employee addEmployee(Employee employee) {
		return er.save(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return er.findAll();
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return er.save(employee);
	}

	@Override
	public Employee deleteEmployee(long id) {
		 er.deleteById(id);
		 return null;
	}

	@Override
	public Employee getEmployee(long id) {
		return er.getById(id);
	}

}

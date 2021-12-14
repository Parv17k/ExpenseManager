package com.javaproject.starter.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.javaproject.starter.model.Employee;
import com.javaproject.starter.service.EmployeeService;
@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService es;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployee(){
		return es.getAllEmployee();
	}
	@GetMapping("/employees/{id}")
	public Employee getCompany(@PathVariable String id){
		return es.getEmployee(Long.parseLong(id));
	}
	@PostMapping("/employees")
	public Employee addCompany(@RequestBody Employee employee){
		return es.addEmployee(employee);
	}

	@PutMapping("/employees")
	public Employee updateUser(@RequestBody Employee employee){
		return es.updateEmployee(employee);
	}

	@DeleteMapping("/employees/{id}")
	public Employee deleteUser(@PathVariable String id){
		return es.deleteEmployee(Long.parseLong(id));
	}
}

package com.javaproject.starter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaproject.starter.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{

}

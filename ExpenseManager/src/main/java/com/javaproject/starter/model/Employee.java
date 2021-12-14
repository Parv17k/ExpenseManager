package com.javaproject.starter.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Employee {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)	
private long empId;
private String department;
private String name;
private String email;
@ManyToOne
private Company company;
@OneToMany(mappedBy="employee")
private List<Expense> expenses;
public long getEmpId() {
	return empId;
}
public void setEmpId(long empId) {
	this.empId = empId;
}
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Company getCompany() {
	return company;
}
public void setCompany(Company company) {
	this.company = company;
}
public List<Expense> getExpenses() {
	return expenses;
}
public void setExpenses(List<Expense> expenses) {
	this.expenses = expenses;
}

}

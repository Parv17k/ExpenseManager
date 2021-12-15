package com.javaproject.starter.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
@Entity

public class Employee {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)	
private long id;

public Employee() {}
private String department;
private String name;
private String email;
@ManyToOne
private Company company;
@OneToMany(mappedBy="employee")
private List<Expense> expenses;
public long getEmpId() {
	return id;
}
public void setEmpId(long empId) {
	this.id = empId;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((company == null) ? 0 : company.hashCode());
	result = prime * result + ((department == null) ? 0 : department.hashCode());
	result = prime * result + ((email == null) ? 0 : email.hashCode());
	result = prime * result + (int) (id ^ (id >>> 32));
	result = prime * result + ((expenses == null) ? 0 : expenses.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Employee other = (Employee) obj;
	if (company == null) {
		if (other.company != null)
			return false;
	} else if (!company.equals(other.company))
		return false;
	if (department == null) {
		if (other.department != null)
			return false;
	} else if (!department.equals(other.department))
		return false;
	if (email == null) {
		if (other.email != null)
			return false;
	} else if (!email.equals(other.email))
		return false;
	if (id != other.id)
		return false;
	if (expenses == null) {
		if (other.expenses != null)
			return false;
	} else if (!expenses.equals(other.expenses))
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	return true;
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
public long getCompany() {
	return company.getId();
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

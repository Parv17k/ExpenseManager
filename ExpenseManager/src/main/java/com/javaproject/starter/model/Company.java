package com.javaproject.starter.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Company {
public Company() {}
@Id
@GeneratedValue(strategy = GenerationType.AUTO)	
private long id;
private String companyName;

@ManyToOne
private User owner;

public String getOwner() {
	try {
	return owner.getEmailID();
	}
	catch(Exception e)
	{
	return null;	
	}
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getCompanyName() {
	return companyName;
}
public void setCompanyName(String companyName) {
	this.companyName = companyName;
}

public Company(long id, String companyName, User owner, String desc, List<Employee> employees) {
	super();
	this.id = id;
	this.companyName = companyName;
	this.owner = owner;
	this.desc = desc;
	this.employees = employees;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
	result = prime * result + ((desc == null) ? 0 : desc.hashCode());
	result = prime * result + ((employees == null) ? 0 : employees.hashCode());
	result = prime * result + (int) (id ^ (id >>> 32));
	result = prime * result + ((owner == null) ? 0 : owner.hashCode());
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
	Company other = (Company) obj;
	if (companyName == null) {
		if (other.companyName != null)
			return false;
	} else if (!companyName.equals(other.companyName))
		return false;
	if (desc == null) {
		if (other.desc != null)
			return false;
	} else if (!desc.equals(other.desc))
		return false;
	if (employees == null) {
		if (other.employees != null)
			return false;
	} else if (!employees.equals(other.employees))
		return false;
	if (id != other.id)
		return false;
	if (owner == null) {
		if (other.owner != null)
			return false;
	} else if (!owner.equals(other.owner))
		return false;
	return true;
}
public void setOwner(User owner) {
	this.owner = owner;
}
public String getDesc() {
	return desc;
}
public void setDesc(String desc) {
	this.desc = desc;
}
public List<Employee> getEmployees() {
	return employees;
}
public void setEmployees(List<Employee> employees) {
	this.employees = employees;
}
private String desc;
@OneToMany(mappedBy="company",cascade = CascadeType.ALL)
private List<Employee> employees;
}

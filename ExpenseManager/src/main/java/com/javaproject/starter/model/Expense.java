package com.javaproject.starter.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Expense {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long id;
private String shortDesc;
public double getExpenseCost() {
	return expenseCost;
}
public void setExpenseCost(double expenseCost) {
	this.expenseCost = expenseCost;
}
public User getCreatedBy() {
	return createdBy;
}
public void setCreatedBy(User createdBy) {
	this.createdBy = createdBy;
}
public ExpenseType getType() {
	return type;
}
public void setType(ExpenseType type) {
	this.type = type;
}
public Employee getEmployee() {
	return employee;
}
public void setEmployee(Employee employee) {
	this.employee = employee;
}

private double expenseCost;
private String longDesc;
@ManyToOne
private User createdBy;
@ManyToOne
private ExpenseType type;

@ManyToOne
private Employee employee;

public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getShortDesc() {
	return shortDesc;
}
public void setShortDesc(String shortDesc) {
	this.shortDesc = shortDesc;
}

public String getLongDesc() {
	return longDesc;
}
public void setLongDesc(String longDesc) {
	this.longDesc = longDesc;
}

public String getExpenseurl() {
	return Expenseurl;
}
public void setExpenseurl(String expenseurl) {
	Expenseurl = expenseurl;
}


public Date getCreated() {
	return created;
}
public void setCreated(Date created) {
	this.created = created;
}
public Date getModified() {
	return modified;
}
public void setModified(Date modified) {
	this.modified = modified;
}

private String Expenseurl;
@CreationTimestamp
private Date created;

@UpdateTimestamp
private Date modified;



}

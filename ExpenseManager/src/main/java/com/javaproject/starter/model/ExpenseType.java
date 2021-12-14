package com.javaproject.starter.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class ExpenseType {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long id;
private String type;
private String Desc;
@OneToMany(mappedBy="type")
private List<Expense> expenses;
public List<Expense> getExpenses() {
	return expenses;
}
public void setExpenses(List<Expense> expenses) {
	this.expenses = expenses;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getDesc() {
	return Desc;
}
public void setDesc(String desc) {
	Desc = desc;
}

}

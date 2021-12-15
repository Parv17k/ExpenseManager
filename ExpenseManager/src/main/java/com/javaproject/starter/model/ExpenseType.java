package com.javaproject.starter.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class ExpenseType {
	public ExpenseType() {}
public ExpenseType(long id, String type, String desc, List<Expense> expenses) {
		super();
		this.id = id;
		this.type = type;
		Desc = desc;
		this.expenses = expenses;
	}
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long id;
private String type;
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((Desc == null) ? 0 : Desc.hashCode());
	result = prime * result + ((expenses == null) ? 0 : expenses.hashCode());
	result = prime * result + (int) (id ^ (id >>> 32));
	result = prime * result + ((type == null) ? 0 : type.hashCode());
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
	ExpenseType other = (ExpenseType) obj;
	if (Desc == null) {
		if (other.Desc != null)
			return false;
	} else if (!Desc.equals(other.Desc))
		return false;
	if (expenses == null) {
		if (other.expenses != null)
			return false;
	} else if (!expenses.equals(other.expenses))
		return false;
	if (id != other.id)
		return false;
	if (type == null) {
		if (other.type != null)
			return false;
	} else if (!type.equals(other.type))
		return false;
	return true;
}
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

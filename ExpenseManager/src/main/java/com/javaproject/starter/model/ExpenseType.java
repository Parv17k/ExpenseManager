package com.javaproject.starter.model;

import java.util.ArrayList;
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
public String getUser() {
	return user.getEmailID();
}
public void setUser(User user) {
	this.user = user;
}
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long id;
private String type;
@ManyToOne
private User user;

private String Desc;
@OneToMany(mappedBy="type")
private List<Expense> expenses;
public List<Long> getExpenses() {
	List<Long> exp=new ArrayList<Long>();
	for(Expense e:expenses)
	{
		exp.add(e.getId());
	}
	return exp;
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

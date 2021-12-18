package com.javaproject.starter.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
//http://localhost:90/sendemail?id=3&to=khatriparv@gmail.com
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Expense {
	
	public Expense() {}

@Override
	public String toString() {
		return "Expense [id=" + id + ", " + (shortDesc != null ? "shortDesc=" + shortDesc + ", " : "") + "expenseCost="
				+ expenseCost + ", " + (longDesc != null ? "longDesc=" + longDesc + ", " : "")
				+ (createdby != null ? "createdBy=" + createdby + ", " : "")
				+ (type != null ? "type=" + type + ", " : "") + (employee != null ? "employee=" + employee + ", " : "")
				+ (Expenseurl != null ? "Expenseurl=" + Expenseurl + ", " : "")
				+ (created != null ? "created=" + created + ", " : "")
				+ (modified != null ? "modified=" + modified : "") + "]";
	}

@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Expenseurl == null) ? 0 : Expenseurl.hashCode());
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + ((createdby == null) ? 0 : createdby.hashCode());
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		long temp;
		temp = Double.doubleToLongBits(expenseCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((longDesc == null) ? 0 : longDesc.hashCode());
		result = prime * result + ((modified == null) ? 0 : modified.hashCode());
		result = prime * result + ((shortDesc == null) ? 0 : shortDesc.hashCode());
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
		Expense other = (Expense) obj;
		if (Expenseurl == null) {
			if (other.Expenseurl != null)
				return false;
		} else if (!Expenseurl.equals(other.Expenseurl))
			return false;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (createdby == null) {
			if (other.createdby != null)
				return false;
		} else if (!createdby.equals(other.createdby))
			return false;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		if (Double.doubleToLongBits(expenseCost) != Double.doubleToLongBits(other.expenseCost))
			return false;
		if (id != other.id)
			return false;
		if (longDesc == null) {
			if (other.longDesc != null)
				return false;
		} else if (!longDesc.equals(other.longDesc))
			return false;
		if (modified == null) {
			if (other.modified != null)
				return false;
		} else if (!modified.equals(other.modified))
			return false;
		if (shortDesc == null) {
			if (other.shortDesc != null)
				return false;
		} else if (!shortDesc.equals(other.shortDesc))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

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
public String getCreatedBy() {
	return createdby.getEmailID();
}
public void setCreatedBy(User createdBy) {
	this.createdby = createdBy;
}
public long getType() {
	return type.getId();
}
public void setType(ExpenseType type) {
	this.type = type;
}
public long getEmployee() {
	return employee.getEmpId();
}
public void setEmployee(Employee employee) {
	this.employee = employee;
}

private double expenseCost;
private String longDesc;
@ManyToOne
private User createdby;
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

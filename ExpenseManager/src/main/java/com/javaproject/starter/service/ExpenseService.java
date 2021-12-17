package com.javaproject.starter.service;

import java.util.List;

import com.javaproject.starter.model.Company;
import com.javaproject.starter.model.Expense;
import com.javaproject.starter.model.User;

public interface ExpenseService {
	
		public Expense addExpense(Expense expense); //create
		public List<Expense> getExpense(); // ReadAll
		public Expense updateExpense(Expense expense);//Update
		public Expense deleteExpense(long id);//Delete
		public Expense getExpense(long id);// Read


}

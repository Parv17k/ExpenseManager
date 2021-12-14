package com.javaproject.starter.service;

import java.util.List;


import com.javaproject.starter.model.ExpenseType;

public interface ExpenseTypeService {
public ExpenseType addExpenseType(ExpenseType expenseType); //create
public List<ExpenseType> getExpenseTypes(); // ReadAll
public ExpenseType updateExpenseType(ExpenseType expenseType);//Update
public ExpenseType deleteExpenseType(long id);//Delete
public ExpenseType getExpenseType(long id);// Read



}

package com.javaproject.starter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaproject.starter.model.Expense;
import com.javaproject.starter.repository.ExpenseRepository;

@Service
public class ExpenseServiceImpl implements ExpenseService  {
	@Autowired
	ExpenseRepository er;
	@Override
	public Expense addExpense(Expense expense) {
		return er.save(expense);
	}

	@Override
	public List<Expense> getExpense() {
		return er.findAll();
	}

	@Override
	public Expense updateExpense(Expense expense) {
		return er.save(expense);
	}

	@Override
	public Expense deleteExpense(long id) {
		er.deleteById(id);
		return null;
	}

	@Override
	public Expense getExpense(long id) {
		return er.getById(id);
	}

	

}

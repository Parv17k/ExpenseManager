package com.javaproject.starter.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.javaproject.starter.model.Expense;
import com.javaproject.starter.repository.ExpenseRepository;

@Service
public class ExpenseServiceImpl implements ExpenseService  {
	ExpenseRepository er;
	@Override
	public Expense addExpense(Expense expense) {
		// TODO Auto-generated method stub
		return er.save(expense);
	}

	@Override
	public List<Expense> getExpense() {
		// TODO Auto-generated method stub
		return er.findAll();
	}

	@Override
	public Expense updateExpense(Expense expense) {
		// TODO Auto-generated method stub
		return er.save(expense);
	}

	@Override
	public Expense deleteExpense(long id) {
		// TODO Auto-generated method stub
		er.deleteById(id);
		return null;
	}

	@Override
	public Expense getExpense(long id) {
		// TODO Auto-generated method stub
		return er.getById(id);
	}

}

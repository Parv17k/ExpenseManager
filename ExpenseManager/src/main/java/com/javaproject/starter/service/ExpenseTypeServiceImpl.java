package com.javaproject.starter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaproject.starter.model.ExpenseType;
import com.javaproject.starter.repository.ExpenseTypeRepository;

@Service
public class ExpenseTypeServiceImpl implements ExpenseTypeService {
	@Autowired
	ExpenseTypeRepository etr;

	@Override
	public ExpenseType addExpenseType(ExpenseType expenseType) {
	return etr.save(expenseType);
	}

	@Override
	public List<ExpenseType> getExpenseTypes() {
		return etr.findAll();
	}


	@Override
	public ExpenseType updateExpenseType(ExpenseType expenseType) {
		return etr.save(expenseType);
	}

	@Override
	public ExpenseType deleteExpenseType(long id) {
		etr.deleteById(id);
		return null;
	}

	@Override
	public ExpenseType getExpenseType(long id) {
		return etr.getById(id);
	}

	@Override
	public List<ExpenseType> getExpenseTypeByEmail(String email) {
		return etr.getByUser(email);
	}

}

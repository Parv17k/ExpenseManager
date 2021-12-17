package com.javaproject.starter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaproject.starter.model.Expense;
import com.javaproject.starter.model.ExpenseType;
import com.javaproject.starter.service.ExpenseService;
import com.javaproject.starter.service.ExpenseTypeService;

@RestController
public class ExpenseTypeController {
	@Autowired
	private ExpenseTypeService es;
		
	@GetMapping("/expensetype")
	public List<ExpenseType> getAllUsers(){
		return es.getExpenseTypes();
	}

	@GetMapping("/expensetype/{id}")
	public ExpenseType getExpenseType(@PathVariable String id){
		return es.getExpenseType(Long.parseLong(id));
	}

	@PostMapping("/expensetype")
	public ExpenseType addExpenseType(@RequestBody ExpenseType expense){
		return es.addExpenseType(expense);
	}

	@PutMapping("/expensetype")
	public ExpenseType updateExpenseType(@RequestBody ExpenseType expense){
		return es.addExpenseType(expense);
	}
	@DeleteMapping("/expensetype/{id}")
	public ExpenseType deleteExpenseType(@PathVariable String id){
		return es.deleteExpenseType(Long.parseLong(id));
	}
	@GetMapping("/expensetype/{email}")
	public List<ExpenseType> getExpenseTypeByEmail(@PathVariable String email){
		return es.getExpenseTypeByEmail(email);
	}
}

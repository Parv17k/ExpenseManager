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
import com.javaproject.starter.model.User;
import com.javaproject.starter.service.ExpenseService;
import com.javaproject.starter.service.UserService;

@RestController
public class ExpenseController {
	@Autowired
	private ExpenseService es;
		
	@GetMapping("/expense")
	public List<Expense> getAllUsers(){
		return es.getExpense();
	}

	@GetMapping("/expense/{id}")
	public Expense getExpense(@PathVariable String id){
		return es.getExpense(Long.parseLong(id));
	}

	@PostMapping("/expense")
	public Expense addExpense(@RequestBody Expense expense){
		return es.addExpense(expense);
	}

	@PutMapping("/expense")
	public Expense updateExpense(@RequestBody Expense expense){
		return es.addExpense(expense);
	}
	@DeleteMapping("/expense/{id}")
	public Expense deleteExpense(@PathVariable String id){
		return es.deleteExpense(Long.parseLong(id));
	}
}

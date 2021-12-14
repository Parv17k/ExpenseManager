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
		
	@GetMapping("/expenses")
	public List<Expense> getAllUsers(){
		return es.getExpense();
	}

	@GetMapping("/expenses/{id}")
	public Expense getExpense(@PathVariable String id){
		return es.getExpense(Long.parseLong(id));
	}

	@PostMapping("/expenses")
	public Expense addExpense(@RequestBody Expense expense){
		return es.addExpense(expense);
	}

	@PutMapping("/expenses")
	public Expense updateExpense(@RequestBody Expense expense){
		return es.addExpense(expense);
	}
	@DeleteMapping("/expenses/{id}")
	public Expense deleteExpense(@PathVariable String id){
		return es.deleteExpense(Long.parseLong(id));
	}
}

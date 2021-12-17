package com.javaproject.starter.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

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
		@GetMapping("/expense/csv")
	    public void exportToCSV(@RequestParam String email,HttpServletResponse response) throws IOException {
			String[] header = {"ID", "CREATED", "EXPENSE_COST", "LONG_DESC", "SHORT_DESC","CREATEDBY_EMAIL","EMPLOYEE_ID","TYPE_ID"};
	        String[] mapping = {"id", "created", "expenseCost", "longDesc", "shortDesc","createdby","employee","type"};
	         
	        
	        String cdt = (new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss")).format(new Date());
	         
	        response.setContentType("text/csv");
	        response.setHeader("Content-Disposition","attachment;filename=expense"+cdt + ".csv");
	         
	        List<Expense> listExpenses = es.getExpense();
	 
	        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
	        //ID  	EXPENSEURL  	CREATED  	EXPENSE_COST  	LONG_DESC  	MODIFIED  	SHORT_DESC  	CREATEDBY_EMAIL  	EMPLOYEE_ID  	TYPE_ID  
	        csvWriter.writeHeader(header);
	         
	        for(Expense expense : listExpenses) 
	        	if(expense.getCreatedBy().equals(email))
	            csvWriter.write(expense, mapping);
	     
	         csvWriter.close();
	         
	    }
}

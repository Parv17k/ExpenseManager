package com.javaproject.starter.controller;

import org.springframework.security.core.Authentication;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaproject.starter.model.Expense;
import com.javaproject.starter.model.User;
import com.javaproject.starter.service.ExpenseService;
import com.javaproject.starter.service.MailService;
import com.javaproject.starter.service.UserService;

@Controller
public class MainController{
	@Autowired
	private UserService us;
	@Autowired
	private MailService ms;
	@Autowired
	private ExpenseService es;
	
	@RequestMapping("index")
	public String indexPage() {
	return "home.jsp";
	}
	 
	
	@GetMapping(value = "/username")
	  @ResponseBody
	    public String currentUserName(Authentication authentication) {
	    
		 String us = SecurityContextHolder.getContext().getAuthentication().getName();
		  if (StringUtils.isEmpty(us)) {
		    us = "";
		  }
		  return us;
	    }

	@RequestMapping("login")
	public String loginPage( ) {
		return "login.jsp";
	}
	

	
	@RequestMapping("/sendemail")
	public String sendEmail(@RequestParam String text,@RequestParam String to,HttpServletResponse response) {
		try {
		ms.sendMail(text, to);
		response.setStatus(HttpServletResponse.SC_ACCEPTED);
		return "Done";
		}
		catch(Exception e){
			e.printStackTrace();response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return "Error";
		}
	
	}
	@RequestMapping("/emailsender")
	public String emailSender(@RequestParam String text,@RequestParam String to) {
	
		return "emailSender.jsp";
	
	
	}
	
	@RequestMapping(value = "/expensetypemanagement", method = RequestMethod.GET)
	public String expenseTypePage() {
		
		return "expensetype.jsp";
	}
	@RequestMapping(value = "/employeemanagement", method = RequestMethod.GET)
	public String employeePage() {
		return "employee.jsp";
	}
	
@RequestMapping(value = "/company", method = RequestMethod.GET)
public String companyPage() {
	
	return "company.jsp";
}
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration() {
		
		return "signup.jsp";
	}
	
	@RequestMapping(value = "/registration",method = RequestMethod.POST)
	public String signupPage(@RequestBody User user) {
		us.addUser(user);
		return "redirect:/index";
	}

	

}

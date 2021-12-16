package com.javaproject.starter.controller;

import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaproject.starter.model.User;
import com.javaproject.starter.service.UserService;

@Controller
public class MainController{
	@Autowired
	private UserService us;

	@RequestMapping("index")
	public String indexPage() {
	
		return "home.jsp";
	}
	 @GetMapping(value = "/username")
	  @ResponseBody
	    public String currentUserName(Authentication authentication) {
	    
		 String username = SecurityContextHolder.getContext().getAuthentication().getName();
		  if (StringUtils.isEmpty(username)) {
		    username = "";
		  }
		  return username;

	    }
	@RequestMapping("login")
	public String loginPage( ) {
		return "login.jsp";
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

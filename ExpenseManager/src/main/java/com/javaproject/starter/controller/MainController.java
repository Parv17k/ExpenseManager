package com.javaproject.starter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.javaproject.starter.Security.SecurityService;
import com.javaproject.starter.model.User;
import com.javaproject.starter.service.UserService;

@Controller
public class MainController{
	@Autowired
	private UserService us;
	@Autowired
	private SecurityService ss;
	@RequestMapping("index")
	public String indexPage(String name ) {
		return "index.jsp";
	}
	@RequestMapping("login")
	public String loginPage( ) {
		return "login.jsp";
	}
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration() {
		System.out.print("Reg1");
		return "registration.jsp";
	}
	
	@RequestMapping(value = "/registration",method = RequestMethod.POST)
	public String signupPage(@RequestBody User user) {
		System.out.print("Reg");
		us.addUser(user);

		ss.autologin(user.getEmailID(), user.getPassword());

		return "redirect:/index";
	}

	@RequestMapping(value="home")
	public ModelAndView home(@RequestParam String user)
	{
		System.out.print(user);
		ModelAndView mv= new ModelAndView("home.jsp");
		mv.addObject("name",user);
		return mv;
	}

}

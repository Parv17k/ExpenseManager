package com.javaproject.starter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController{
	@RequestMapping("index")
	public String indexPage(String name ) {
		return "index.jsp";
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

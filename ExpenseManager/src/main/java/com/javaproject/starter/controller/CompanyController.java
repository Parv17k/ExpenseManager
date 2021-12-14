package com.javaproject.starter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaproject.starter.model.Company;
import com.javaproject.starter.service.CompanyService;

@RestController
public class CompanyController {
	@Autowired
	private CompanyService cs;
	
	@GetMapping("/Companies")
	public List<Company> getCompanies(){
	
		return this.cs.getCompanies();
		
	}
	@GetMapping("/Company")
	public Company getCompany(@RequestParam String companyId){
	
		return null;
		
	}
}

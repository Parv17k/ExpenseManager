package com.javaproject.starter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaproject.starter.model.Company;
import com.javaproject.starter.model.User;
import com.javaproject.starter.service.CompanyService;

@RestController
public class CompanyController {
@Autowired
private CompanyService cs;


@GetMapping("/companies")
public List<Company> getAllCompanies(){
	return cs.getAllCompanies();
}

@GetMapping("/companies/{id}")
public Company getCompany(@PathVariable String id){
	return cs.getCompany(Long.parseLong(id));
}

@PostMapping("/companies")
public Company addCompany(@RequestBody Company company){
	return cs.addCompany(company);
}

@PutMapping("/companies")
public Company updateCompany(@RequestBody Company company){
	return cs.addCompany(company);
}

@DeleteMapping("/companies/{id}")
public Company deleteCompany(@PathVariable String id){
	cs.deleteCompany(Long.parseLong(id));
	return null;
}

}

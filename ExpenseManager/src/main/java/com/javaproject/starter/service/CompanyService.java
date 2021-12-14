package com.javaproject.starter.service;
import java.util.List;

import com.javaproject.starter.model.*;
public interface CompanyService {
	public Company addCompany(Company company); //create
	public List<Company> getAllCompanies(); // ReadAll
	public Company updateCompany(Company company);//Update
	public Company deleteCompany(long id);//Delete
	public Company getCompany(long id);// Read
}

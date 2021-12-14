package com.javaproject.starter.service;
import java.util.List;

import com.javaproject.starter.model.*;
public interface CompanyService {
public List<Company> getCompanies();
public Company getCompany();
public User getOwner();
public List<Expense> getExpenses();
public List<Employee> getEmployees();

}

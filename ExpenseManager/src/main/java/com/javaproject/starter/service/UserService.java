package com.javaproject.starter.service;

import java.util.List;

import com.javaproject.starter.model.*;
public interface UserService {
public User addUser(User user); //create
public List<User> getUsers(); // ReadAll
public User updateUser(User user);//Update
public User deleteUser(String emailId);//Delete
public User getUser(String emailId);// Read
public List<Expense> getExpenses(User user);//Read All Expense 
public List<Company> getCompanies(User user); // Read All companies

}

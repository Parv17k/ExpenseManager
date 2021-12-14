package com.javaproject.starter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaproject.starter.model.Company;
import com.javaproject.starter.model.Expense;
import com.javaproject.starter.model.User;
import com.javaproject.starter.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepository ur;
	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return ur.save(user);
		
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return ur.findAll();
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		
		return ur.save(user);
	}

	@Override
	public User deleteUser(String emailId) {
		// TODO Auto-generated method stub
		
		ur.deleteById(emailId);
		return null;
	}

	@Override
	public User getUser(String emailId) {
		// TODO Auto-generated method stub
		return ur.getById(emailId);
	}

	@Override
	public List<Expense> getExpenses(User user) {
		// TODO Auto-generated method stub
		//var user=ur.getById(User);
		return null;
	}

	@Override
	public List<Company> getCompanies(User user) {
		// TODO Auto-generated method stub
		return null;
	}


}

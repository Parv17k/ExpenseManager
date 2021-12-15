package com.javaproject.starter.Security;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.GrantedAuthority;

import com.javaproject.starter.model.Company;	
import com.javaproject.starter.model.Expense;
import com.javaproject.starter.model.Role;
import com.javaproject.starter.model.User;
import com.javaproject.starter.repository.UserRepository;
import com.javaproject.starter.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
@Service
public class UserDetailServiceImplemented implements UserDetailsService{
	@Autowired
	private UserRepository ur;


	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String email)
			throws UsernameNotFoundException {
		User user=null;
	try {
		 user = ur.findByEmail(email);
	}
	catch(UsernameNotFoundException e)
	{
				new UsernameNotFoundException(String.format("User not found", email));;
	}

		Set<GrantedAuthority> ga = new HashSet<>();
		for (Role role : user.getRoles()){
			ga.add(new SimpleGrantedAuthority(role.getName()));
		}

		return new org.springframework.security.core.userdetails.User(user.getEmailID(),user.getPassword(), ga);
		
	}
}

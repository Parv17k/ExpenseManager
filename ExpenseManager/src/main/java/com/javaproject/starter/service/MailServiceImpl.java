package com.javaproject.starter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.javaproject.starter.model.Expense;
import com.javaproject.starter.repository.ExpenseRepository;
@Service
public class MailServiceImpl implements MailService {
	 	@Autowired
	    private JavaMailSender emailSender;
	 	@Autowired
		ExpenseRepository er;
	  
		@Override
		public void sendMail(String text, String to) {
		
	    
	        SimpleMailMessage m = new SimpleMailMessage(); 
	        m.setFrom("managerexpensejava@gmail.com");
	        m.setTo(to); 
	        m.setSubject("Expense Detail"); 
	        m.setText(text);
	        emailSender.send(m);
	    	}
	
}

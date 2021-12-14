package com.javaproject.starter.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.javaproject.starter.model.User;
import com.javaproject.starter.repository.UserRepository;
import com.javaproject.starter.service.CompanyService;
import com.javaproject.starter.service.UserService;
@RestController
public class UserController {
@Autowired
private UserService us;
	
@GetMapping("/users")
public List<User> getAllUsers(){
	return us.getUsers();
}

@GetMapping("/user/{emailid}")
public User getUser(@PathVariable String emailid){
	return us.getUser(emailid);
}

@PostMapping("/user")
public User addUser(@RequestBody User user){
	return us.addUser(user);
}

@PutMapping("/user")
public User updateUser(@RequestBody User user){
	return us.addUser(user);
}
@DeleteMapping("/user/{emailid}")
public User deleteUser(@PathVariable String emailid){
	return us.deleteUser(emailid);
}


}

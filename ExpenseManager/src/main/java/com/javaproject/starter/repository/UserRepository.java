package com.javaproject.starter.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.javaproject.starter.model.User;

public interface UserRepository extends JpaRepository<User,String>{

}

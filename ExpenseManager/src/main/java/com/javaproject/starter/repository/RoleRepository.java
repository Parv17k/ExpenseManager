package com.javaproject.starter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaproject.starter.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
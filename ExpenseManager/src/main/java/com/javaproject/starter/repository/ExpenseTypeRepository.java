package com.javaproject.starter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaproject.starter.model.ExpenseType;

public interface ExpenseTypeRepository extends JpaRepository<ExpenseType,Long>{

}

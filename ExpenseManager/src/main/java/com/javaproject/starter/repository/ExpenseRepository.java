package com.javaproject.starter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaproject.starter.model.Expense;

public interface ExpenseRepository extends JpaRepository<Expense,Long> {

}

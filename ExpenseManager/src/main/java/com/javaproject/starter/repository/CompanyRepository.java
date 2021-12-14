package com.javaproject.starter.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.javaproject.starter.model.Company;

public interface CompanyRepository extends JpaRepository<Company,Long>{

}

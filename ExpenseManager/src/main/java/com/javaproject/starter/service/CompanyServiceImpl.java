package com.javaproject.starter.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.javaproject.starter.model.Company;
import com.javaproject.starter.repository.CompanyRepository;
@Service
public class CompanyServiceImpl implements CompanyService {
	@Autowired
	CompanyRepository cr;
	@Override
	public Company addCompany(Company company) {
		return cr.save(company);
	}
	
	@Override
	public List<Company> getAllCompanies() {
		return cr.findAll();
	}

	@Override
	public Company updateCompany(Company company) {
		return cr.save(company);
	}

	@Override
	public Company deleteCompany(long id) {
		cr.deleteById(id);
		return null;
	}

	@Override
	public Company getCompany(long id) {
	return cr.getById(id);
	}

}

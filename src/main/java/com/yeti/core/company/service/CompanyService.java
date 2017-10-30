package com.yeti.core.company.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yeti.core.company.repository.CompanyRepository;
import com.yeti.model.company.Company;
import com.yeti.model.util.Batch;

@Service
public class CompanyService {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	public List<Company> getAllCompanies() {
		List<Company> companys = new ArrayList<Company>();
		companyRepository.findAll().forEach(companys::add);
		return companys;
	}
	
	public Company getCompany(Integer id) {
		return companyRepository.findOne(id);
	}
	
	public Company addCompany(Company company) {
		return companyRepository.save(company);
	}

	public Company updateCompany(Integer id, Company company) {
		return companyRepository.save(company);
	}

	public void deleteCompany(Integer id) {
		companyRepository.delete(id);
	}
	
	public void processBatchAction(Batch batch) {
		// TODO: Write logic for batch processing
	}
	
	public boolean exists(Integer id) {
		return companyRepository.exists(id);
	}
	
}

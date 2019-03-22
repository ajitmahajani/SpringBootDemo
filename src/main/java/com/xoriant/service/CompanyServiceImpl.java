package com.xoriant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.xoriant.entity.Company;
import com.xoriant.exception.CompanyException;
import com.xoriant.repository.CompanyRepo;

/**
 * Company Service CRUD operation
 * @author mahajan_a
 *
 */

@Service
public class CompanyServiceImpl implements ICompany{

	@Autowired
	CompanyRepo companyRepo;
	
	
	public Company addCompany(@RequestBody Company company) throws CompanyException{
		if(company.getName() == null){
			throw new CompanyException("Invalid Input. Missing company name");
		}
		
		if(company.getAddress() == null){
			throw new CompanyException("Invalid Input. Missing company address");
		}
		return companyRepo.save(company);
	}
	
	public List<Company> getAllCompanies() throws CompanyException{
		return companyRepo.findAll();
	}
}

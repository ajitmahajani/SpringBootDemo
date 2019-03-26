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
 * 
 * @author mahajan_a
 *
 */

@Service
public class CompanyServiceImpl implements ICompany {

	@Autowired
	CompanyRepo companyRepo;

	public Company addCompany(@RequestBody Company company) throws CompanyException {
		if (company.getName() == null) {
			throw new CompanyException("Invalid Input. Missing company name");
		}

		if (company.getAddress() == null) {
			throw new CompanyException("Invalid Input. Missing company address");
		}
		
		if (company.getId() != null) {
			company.setId(null);
		}
		
		return companyRepo.save(company);
	}

	public List<Company> getAllCompanies() throws CompanyException {
		return companyRepo.findAll();
	}

	@Override
	public Company updateCompany(Company company) throws CompanyException {
		if (company.getId() == null) {
			throw new CompanyException("Invalid Input. Missing company id to be updated");
		}

		if (company.getName() == null) {
			throw new CompanyException("Invalid Input. Missing company name");
		}

		if (company.getAddress() == null) {
			throw new CompanyException("Invalid Input. Missing company address");
		}

		if (!companyRepo.existsById(company.getId())) {
			throw new CompanyException("Invalid Input. No such company id exists");
		}

		return companyRepo.save(company);
	}

	@Override
	public void deleteCompany(Long companyId) throws CompanyException {
		if (companyId == null) {
			throw new CompanyException("Invalid Input. Provide the company id to be deleted");
		}
		
		if (!companyRepo.existsById(companyId)) {
			throw new CompanyException("Invalid Input. No such company id exists");
		}
		
		Company company = companyRepo.getOne(companyId);
		companyRepo.delete(company);
		
	}
}

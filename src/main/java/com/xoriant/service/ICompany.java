package com.xoriant.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.xoriant.entity.Company;
import com.xoriant.exception.CompanyException;

/**
 *  Company Service CRUD operation
 * @author mahajan_a
 *
 */
public interface ICompany {

	
	public Company addCompany(@RequestBody Company company) throws CompanyException;
	public List<Company> getAllCompanies() throws CompanyException;
	public Company updateCompany(@RequestBody Company company) throws CompanyException;
	public void deleteCompany(@PathVariable Long companyId) throws CompanyException;
}

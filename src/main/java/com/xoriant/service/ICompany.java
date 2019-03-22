package com.xoriant.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.xoriant.entity.Company;
import com.xoriant.exception.CompanyException;

/**
 *  Company Service CRUD operation
 * @author mahajan_a
 *
 */
public interface ICompany {

	
	public Company addCompany(@RequestBody Company compay) throws CompanyException;
	public List<Company> getAllCompanies() throws CompanyException;
}

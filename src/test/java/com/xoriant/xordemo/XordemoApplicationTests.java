package com.xoriant.xordemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.xoriant.entity.Company;
import com.xoriant.exception.CompanyException;
import com.xoriant.service.CompanyServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class XordemoApplicationTests {

	@Autowired
	private CompanyServiceImpl service;
	
	
	@Test(expected = CompanyException.class)
	public void NullCompanyName_ThenFail() throws Exception{
		Company company =  new Company();
		company.setAddress("TestAddress");
		service.addCompany(company);
	}
	
	@Test(expected = CompanyException.class)
	public void NullCompanyAddress_ThenFail() throws Exception{
		Company company =  new Company();
		company.setAddress("TestName");
		service.addCompany(company);
	}

}

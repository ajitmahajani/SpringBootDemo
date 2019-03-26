package com.xoriant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xoriant.entity.Company;
import com.xoriant.exception.CompanyException;
import com.xoriant.response.ErrorRespose;
import com.xoriant.service.ICompany;

/**
 * Controller to handle Company related api
 * 
 * @author mahajan_a
 *
 */

@RestController
@RequestMapping("/api/v1")
public class DemoController {

	@Autowired
	ICompany companyService;

	@RequestMapping("/")
	public String sayHello() {
		return "Hello";
	}

	/**
	 * Add new Company
	 * 
	 * @param useCompany
	 * @return Newly added Company details
	 */
	@RequestMapping(value = "/company", method = RequestMethod.POST)
	public ResponseEntity<?> addCompany(@RequestBody Company useCompany) {
		try {
			Company company = companyService.addCompany(useCompany);
			return getReponseEntity(HttpStatus.OK, company);
		} catch (CompanyException e) {
			ErrorRespose error = new ErrorRespose(e.getMessage());
			return getReponseEntity(HttpStatus.BAD_REQUEST, error);
		}

	}

	/**
	 * List all Companies
	 * 
	 * @return List of Company
	 */

	@RequestMapping(value = "/companies", method = RequestMethod.GET)
	public ResponseEntity<?> getAllCompanies() {

		try {
			List<Company> companies = companyService.getAllCompanies();
			return getReponseEntity(HttpStatus.OK, companies);
		} catch (CompanyException e) {
			ErrorRespose error = new ErrorRespose(e.getMessage());
			return getReponseEntity(HttpStatus.BAD_REQUEST, error);
		}
	}

	/**
	 * Update Company 
	 * 
	 * @param useCompany
	 * @return
	 */
	@RequestMapping(value = "/company/update", method = RequestMethod.PUT)
	public ResponseEntity<?> updateCompany(@RequestBody Company useCompany) {
		try {
			Company company = companyService.updateCompany(useCompany);
			return getReponseEntity(HttpStatus.OK, company);
		} catch (CompanyException e) {
			ErrorRespose error = new ErrorRespose(e.getMessage());
			return getReponseEntity(HttpStatus.BAD_REQUEST, error);
		}

	}

	/**
	 * Delete Company
	 * 
	 * @param companyId
	 * @return
	 */
	@RequestMapping(value = "/company/delete/{companyId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteCompany(@PathVariable Long companyId) {
		try {
			companyService.deleteCompany(companyId);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (CompanyException e) {
			ErrorRespose error = new ErrorRespose(e.getMessage());
			return getReponseEntity(HttpStatus.BAD_REQUEST, error);
		}

	}

	private ResponseEntity<?> getReponseEntity(HttpStatus status, Object respose) {
		return ResponseEntity.status(status).contentType(MediaType.APPLICATION_JSON).body(respose);
	}

}

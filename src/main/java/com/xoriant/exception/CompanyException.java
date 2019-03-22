package com.xoriant.exception;

/**
 * Custome exception for company CRUD operatiom
 * @author mahajan_a
 *
 */
public class CompanyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CompanyException(String message){
		super(message);
	}
}

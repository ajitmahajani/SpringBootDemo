package com.xoriant.response;

public class ErrorRespose {
	private String errorMessage;

	public ErrorRespose(String errorMessage){
		this.errorMessage = errorMessage ;
	}
	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}

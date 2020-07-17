package com.projectk.exceptions;

public class ProjectKException extends Exception{

	private int errorCode;

	private String errorMessage;

	public ProjectKException() {
		super();
	}

	public ProjectKException(Exception ex) {
		super(ex);
	}

	public ProjectKException(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public ProjectKException(String errorMessage, int errorCode) {
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}

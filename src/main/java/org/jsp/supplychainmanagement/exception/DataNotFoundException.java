package org.jsp.supplychainmanagement.exception;

public class DataNotFoundException extends RuntimeException{
	@Override
	public String getMessage() {
		return "Data not present in the database";
	}
}

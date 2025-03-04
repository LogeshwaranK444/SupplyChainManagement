package org.jsp.supplychainmanagement.exception;

public class IdNotFoundException extends RuntimeException{
	@Override
	public String getMessage() {
		return "Id not found in the database";
	}
}

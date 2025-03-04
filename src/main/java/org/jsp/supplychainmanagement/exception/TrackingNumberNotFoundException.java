package org.jsp.supplychainmanagement.exception;

public class TrackingNumberNotFoundException extends RuntimeException {
	
	@Override
	public String getMessage() {
		return "Tracking Number not found in the database";
	}
}

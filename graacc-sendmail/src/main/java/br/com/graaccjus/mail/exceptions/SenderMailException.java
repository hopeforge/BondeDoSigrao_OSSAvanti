package br.com.graaccjus.mail.exceptions;

public class SenderMailException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "The object graaccEmailEntity list of emails this null";
	}
}

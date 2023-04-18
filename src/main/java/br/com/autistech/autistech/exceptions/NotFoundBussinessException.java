package br.com.autistech.autistech.exceptions;


public class NotFoundBussinessException extends BusinessException {

	private static final long serialVersionUID = 5044118827601015808L;

	public NotFoundBussinessException(String message) {
		super(message);
	}
}
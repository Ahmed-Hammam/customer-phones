package com.phone.core.exception;

import lombok.Getter;

public class BusinessException extends RuntimeException{

	private static final long serialVersionUID = 3398903191192170321L;

	public BusinessException(String msg) {
		super(msg);
	}
	
	public BusinessException() {
	}
	
	public BusinessException(Object...params) {
		this.params = params;
	}
	
	public BusinessException(Throwable e) {
		super(e.getMessage(),e);
		this.exception = e;
	}
	
	public BusinessException(Throwable e,Object...params) {
		super(e.getMessage(),e);
		this.params = params;
		this.exception = e;
	}
	
	@Getter
	private Object[] params;
	@Getter
	private Throwable exception;
}
package com.tugsef.services.accountservice.core.utilities.exception;

import lombok.NoArgsConstructor;

/**
 * 
 */
@NoArgsConstructor
public class BussinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BussinessException(String message) {
		super(message);
	}
}

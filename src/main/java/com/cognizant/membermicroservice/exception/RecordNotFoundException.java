package com.cognizant.membermicroservice.exception;

/**
 * 
 * This class used to throw exception if the required data is not available this
 * class extends the RuntimeException class.
 *
 */

public class RecordNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RecordNotFoundException() {
		super();
	}

	public RecordNotFoundException(String message) {
		super(message);
	}

}

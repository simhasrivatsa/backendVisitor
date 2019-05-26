package com.vistorCount.exception;


import com.vistorCount.util.Util;

public class ApiServiceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ServiceExceptionCodes errorCode;
	private String errorMessage;

	public ApiServiceException(ServiceExceptionCodes errorCode) {
		super(errorCode.toString());
		this.errorCode = errorCode;
		this.errorMessage = errorCode.getErrorMessage();
	}

	public ApiServiceException(ServiceExceptionCodes errorCode, String errorMessage) {
		super(errorMessage);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public ApiServiceException(Throwable cause) {
		super(cause);
		this.errorCode = ServiceExceptionCodes.ERROR_SYSTEM_ERROR;
		this.errorMessage = cause.getMessage();
	}

	public ApiServiceException(Throwable cause, ServiceExceptionCodes errorCode) {
		super(cause);
		this.errorCode = errorCode;
		this.errorMessage = cause.getMessage();
	}

	public ServiceExceptionCodes getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		if (Util.isNullOrEmpty(errorMessage))
			return errorCode.getErrorMessage();

		return errorMessage;
	}

}

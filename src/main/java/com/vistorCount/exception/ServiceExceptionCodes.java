package com.vistorCount.exception;


import org.springframework.http.HttpStatus;



public enum ServiceExceptionCodes {

	ERROR_SYSTEM_ERROR(1001, "We are unable to process your request at this moment. Please try again later", HttpStatus.INTERNAL_SERVER_ERROR),

	INVALID_REQUEST(1002, "Something is not right here");



    private HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
	private int errorCode;
	private String errorMessage = "We are unable to process your request at this moment. Please try again later";

	ServiceExceptionCodes(int errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	ServiceExceptionCodes(int errorCode) {
		this.errorCode = errorCode;
	}

	ServiceExceptionCodes(int errorCode, String errorMessage, HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	ServiceExceptionCodes(int errorCode, HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
		this.errorCode = errorCode;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

}

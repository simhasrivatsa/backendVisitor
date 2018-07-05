package com.cartisan.exception.resolver;

import com.cartisan.exception.ApiServiceException;
import com.cartisan.exception.ServiceExceptionCodes;
import com.cartisan.response.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice
public class GlobalExceptionResolver extends ResponseEntityExceptionHandler {



	private static final Logger log = LoggerFactory.getLogger(GlobalExceptionResolver.class);

	@ExceptionHandler(value = ApiServiceException.class)
	public ResponseEntity<ErrorResponse> handleApiServiceException(ApiServiceException ex) throws Exception {
		if (ex.getErrorCode() == ServiceExceptionCodes.ERROR_SYSTEM_ERROR) {
			log.error("Exception occured", ex);
		} else {
			log.error("Request Failed with bad request", ex);

		}
		ErrorResponse response = new ErrorResponse(ex.getErrorCode().getErrorCode(), ex.getErrorMessage());
		return ResponseEntity.status(ex.getErrorCode().getHttpStatus()).body(response);
	}

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ErrorResponse> handleApiServiceException(Exception ex) {
		log.error("Exception occured", ex);


		ErrorResponse response = new ErrorResponse(ServiceExceptionCodes.ERROR_SYSTEM_ERROR.getErrorCode(),
				ServiceExceptionCodes.ERROR_SYSTEM_ERROR.getErrorMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		log.error("Exception occured", ex);

		ErrorResponse response = new ErrorResponse(ServiceExceptionCodes.ERROR_SYSTEM_ERROR.getErrorCode(),
				ServiceExceptionCodes.ERROR_SYSTEM_ERROR.getErrorMessage());
		return ResponseEntity.status(status).body(response);

	}
}

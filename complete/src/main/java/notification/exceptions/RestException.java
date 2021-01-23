package notification.exceptions;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import notification.enums.ErrorCodeEnum;

@RestControllerAdvice
public class RestException extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleException(WebRequest request, HttpServletResponse response, Exception e){
		if(e instanceof ResponseStatusException) {
			ResponseStatusException rse = (ResponseStatusException) e;
			ErrorCodeEnum errorcodeEnum = ErrorCodeEnum.parse(rse.getReason());
			Map<String, String> errors = new HashMap<>();
			errors.put("errorcode", errorcodeEnum.getCode());
			errors.put("message", errorcodeEnum.getDescription());
			errors.put("txID", "12345");
			return handleExceptionInternal(e, errors, new HttpHeaders(), rse.getStatus(), request);
		}
		else {
			return handleExceptionInternal(e, "Unhandled Exception Encountered", new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
		}
	}

}

package com.tcs.service.app.exception;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;

import io.jsonwebtoken.security.SignatureException;
import reactor.core.publisher.Mono;

@RestControllerAdvice
@Order(1)
public class CustomExceptionAdvice {

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BadRequestException.class)
	public Mono<ErrorExceptionResponse> badRequestException(BadRequestException badRequestException) {
		return Mono.just(ErrorExceptionResponse
				.builder()
				.statusCode(400)
				.message(badRequestException.getMessage())
				.build());
	}
	
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(InternalErrorException.class)
	public Mono<ErrorExceptionResponse> badRequestException(InternalErrorException internalErrorException) {
		return Mono.just(ErrorExceptionResponse
				.builder()
				.statusCode(500)
				.message(internalErrorException.getMessage())
				.build());
	}
	
	@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(NotAuthorizedException.class)
	public Mono<ErrorExceptionResponse> badRequestException(NotAuthorizedException notAuthorizedException) {
		return Mono.just(ErrorExceptionResponse
				.builder()
				.statusCode(401)
				.message(notAuthorizedException.getMessage())
				.build());
	}

	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(WebExchangeBindException.class)
	public Mono<ErrorExceptionResponse> webExchangeBindException(WebExchangeBindException webExchangeBindException) {
		
		return Mono.just(ErrorExceptionResponse
				.builder()
				.statusCode(400)
				.message("Incorrect")
				.details(webExchangeBindException.getFieldErrors().stream().map(item -> {
					Map<String, String> mapErrorField = new HashMap<>();
					mapErrorField.put("item", item.getField());
					mapErrorField.put("message", item.getDefaultMessage());
					return mapErrorField;
				}).collect(Collectors.toList()))
				.build());
	}
	

	@ExceptionHandler(SignatureException.class)
    public ResponseEntity<String> handleSignatureException(SignatureException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Error: " + ex.getMessage());
    }
}

package com.tcs.service.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import reactor.core.publisher.Mono;

@RestControllerAdvice
public class CustomExceptionAdvice {

	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(BadRequestException.class)
	public Mono<ErrorExceptionResponse> badRequestException(BadRequestException badRequestException) {
		return Mono.just(ErrorExceptionResponse
				.builder()
				.statusCode(400)
				.message(badRequestException.getMessage())
				.build());
	}

}

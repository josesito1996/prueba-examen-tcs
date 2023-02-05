package com.tcs.service.app.business;

import java.util.List;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICrudGeneric<T, ID> {

	Mono<T> save(T t);

	Flux<T> listAll();

	Mono<T> findById(ID i);
	
	Flux<T> saveAll(List<T> t);

}

package com.tcs.service.app.business.imp;

import java.util.List;

import com.tcs.service.app.business.ICrudGeneric;
import com.tcs.service.app.repository.GenericRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public abstract class CrudGenericImpl<T, ID> implements ICrudGeneric<T, ID> {

	protected abstract GenericRepository<T, ID> getGenericRepository();

	public Mono<T> save(T t) {
		return getGenericRepository().save(t);
	}

	public Flux<T> listAll() {
		return getGenericRepository().findAll();
	}

	public Mono<T> findById(ID id) {
		return getGenericRepository().findById(id);
	}

	public Flux<T> saveAll(List<T> t) {
		return getGenericRepository().findAll();
	}

}

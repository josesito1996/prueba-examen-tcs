package com.tcs.service.app.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

@NoRepositoryBean
public interface GenericRepository<T, ID> extends ReactiveCrudRepository<T, ID> {

}

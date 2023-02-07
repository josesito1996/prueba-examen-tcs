package com.tcs.service.app.repository;

import com.tcs.service.app.entity.UserEntity;

import reactor.core.publisher.Mono;

public interface UserRepository extends GenericRepository<UserEntity, Integer>{

	Mono<UserEntity> findByUserName(String userName);
	
}

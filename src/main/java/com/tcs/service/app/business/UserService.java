package com.tcs.service.app.business;

import com.tcs.service.app.entity.User;

import reactor.core.publisher.Mono;

public interface UserService {
	Mono<User> findByUsername(String username);
}

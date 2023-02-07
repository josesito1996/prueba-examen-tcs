package com.tcs.service.app.business;

import java.util.List;

import com.tcs.service.app.entity.Role;

import reactor.core.publisher.Mono;

public interface RolService {
	Mono<List<Role>> findByIdRole(Integer id);
}

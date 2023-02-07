package com.tcs.service.app.business.imp;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.service.app.business.RolService;
import com.tcs.service.app.entity.Role;
import com.tcs.service.app.entity.RoleEntity;
import com.tcs.service.app.repository.GenericRepository;
import com.tcs.service.app.repository.RoleRepository;

import reactor.core.publisher.Mono;

@Service
public class RolserviceImpl extends CrudGenericImpl<RoleEntity, Integer> implements RolService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	protected GenericRepository<RoleEntity, Integer> getGenericRepository() {

		return roleRepository;
	}

	@Override
	public Mono<List<Role>> findByIdRole(Integer idRole) {
		return roleRepository.findById(idRole)
				.map(role -> {
					if (role.getRolName().equals("ROLE_ADMIN")) {
						return Arrays.asList(Role.ROLE_ADMIN);
					}
					return Arrays.asList(Role.ROLE_USER);
				});
	}
}

package com.tcs.service.app.business.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.service.app.business.RolService;
import com.tcs.service.app.business.UserService;
import com.tcs.service.app.entity.User;
import com.tcs.service.app.entity.UserEntity;
import com.tcs.service.app.repository.GenericRepository;
import com.tcs.service.app.repository.UserRepository;

import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl extends CrudGenericImpl<UserEntity, Integer> implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RolService rolService;
	
	@Override
	protected GenericRepository<UserEntity, Integer> getGenericRepository() {
		
		return userRepository;
	}
	
	@Override
	public Mono<User> findByUsername(String username) {
		
		return userRepository.findByUserName(username).flatMap(user -> {
			return rolService.findByIdRole(user.getIdRole()).map(role -> {
				return User.builder()
						.username(user.getUserName())
						.password(user.getPassword())
						.enabled(true)
						.roles(role)
						.build();
			});
		});
	}
}

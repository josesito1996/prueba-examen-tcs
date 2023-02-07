package com.tcs.service.app;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tcs.service.app.business.ExchangeRateService;
import com.tcs.service.app.config.SecretPasswordEncoder;
import com.tcs.service.app.entity.ExchangeRateEntity;
import com.tcs.service.app.entity.RoleEntity;
import com.tcs.service.app.entity.UserEntity;
import com.tcs.service.app.repository.RoleRepository;
import com.tcs.service.app.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class PruebaExamenTcsApplication implements CommandLineRunner {

	@Autowired
	private ExchangeRateService exchangeRateService;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SecretPasswordEncoder secretPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(PruebaExamenTcsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		roleRepository.saveAll(Arrays.asList(RoleEntity.builder().rolName("ROLE_USER").build(),
				RoleEntity.builder().rolName("ROLE_ADMIN").build())).collectList().subscribe(roles -> {
					log.info("Roles saved : {}", roles);
				});

		userRepository
				.saveAll(
						Arrays.asList(UserEntity.builder().userName("root").password(secretPasswordEncoder.encode("51st3ma$2022.")).idRole(2).build(),
								UserEntity.builder().userName("user").password(secretPasswordEncoder.encode("passwordXDDDD")).idRole(1).build()))
				.subscribe(user -> {
					log.info("User Generated : {}", user);
				});

		exchangeRateService.saveAllCustom(Arrays.asList(
				ExchangeRateEntity.builder().exchangeRateCurrency("SOL").calculationValue(1.0).isActive(true).build(),
				ExchangeRateEntity.builder().exchangeRateCurrency("DOLAR").calculationValue(0.26).isActive(true)
						.build(),
				ExchangeRateEntity.builder().exchangeRateCurrency("EURO").calculationValue(0.24).isActive(true).build(),
				ExchangeRateEntity.builder().exchangeRateCurrency("BITCOIN").calculationValue(0.000005568386344)
						.isActive(true).build(),
				ExchangeRateEntity.builder().exchangeRateCurrency("BOLIVAR").calculationValue(593244.80).isActive(true)
						.build(),
				ExchangeRateEntity.builder().exchangeRateCurrency("PESO").calculationValue(4.92).isActive(true)
						.build()))
				.collectList().subscribe(item -> {
					log.info("IdExchangeRates Generated : {}", item);
				});

	}

}

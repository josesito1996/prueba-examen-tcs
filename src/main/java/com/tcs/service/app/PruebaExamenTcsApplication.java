package com.tcs.service.app;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tcs.service.app.business.ExchangeRateService;
import com.tcs.service.app.entity.ExchangeRateEntity;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class PruebaExamenTcsApplication implements CommandLineRunner {

	@Autowired
	private ExchangeRateService exchangeRateService;

	public static void main(String[] args) {
		SpringApplication.run(PruebaExamenTcsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

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
				.subscribe(item -> {
					log.info("IdExchange : {}", item);
				});

	}

}

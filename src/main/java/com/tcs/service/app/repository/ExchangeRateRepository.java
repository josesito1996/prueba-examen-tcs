package com.tcs.service.app.repository;

import com.tcs.service.app.entity.ExchangeRateEntity;

import reactor.core.publisher.Mono;

public interface ExchangeRateRepository extends GenericRepository<ExchangeRateEntity, Integer> {

	Mono<ExchangeRateEntity> findByExchangeRateCurrency(String exchangeRateCurrency);
	
}

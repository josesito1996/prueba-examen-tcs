package com.tcs.service.app.business;

import java.util.List;

import com.tcs.service.app.entity.ExchangeRateEntity;
import com.tcs.service.app.expose.response.ExchangeRateResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ExchangeRateService {

	Flux<Integer> saveAllCustom(List<ExchangeRateEntity> exchangeRateEntities);

	Flux<ExchangeRateResponse> listAllCustom();

	Mono<ExchangeRateEntity> findByExchangeRateCurrency(String exchangeRateCurrency);
}

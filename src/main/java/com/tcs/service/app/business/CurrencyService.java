package com.tcs.service.app.business;

import com.tcs.service.app.expose.request.ExchangeRateRequest;
import com.tcs.service.app.expose.response.ExchangeRateResponse;

import reactor.core.publisher.Mono;

public interface CurrencyService {

	Mono<ExchangeRateResponse> transformCurrency(ExchangeRateRequest exchangeRateRequest);

}

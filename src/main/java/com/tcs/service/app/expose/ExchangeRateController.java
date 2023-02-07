package com.tcs.service.app.expose;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.service.app.business.CurrencyService;
import com.tcs.service.app.expose.request.ExchangeRateRequest;
import com.tcs.service.app.expose.response.ExchangeRateResponse;

import jakarta.validation.Valid;
import reactor.core.publisher.Mono;

@RequestMapping("/api-exchange-rate")
@RestController
public class ExchangeRateController {

	@Autowired
	private CurrencyService currencyService;

	@PostMapping("/transformCurrency")
	public Mono<ExchangeRateResponse> transformCurrency(@RequestBody 
			@Valid ExchangeRateRequest exchangeRateRequest) {
		return currencyService.transformCurrency(exchangeRateRequest);
	}

}

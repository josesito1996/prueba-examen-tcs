package com.tcs.service.app.business.processor;

import org.springframework.stereotype.Component;

import com.tcs.service.app.entity.ExchangeRateEntity;
import com.tcs.service.app.expose.response.ExchangeRateResponse;

@Component
public class ExchangeRateResponseProcessor { 
	public ExchangeRateResponse toExchangeRateResponse(ExchangeRateEntity exchangeRateEntity) {
		return ExchangeRateResponse.builder()
				
				.build();
	}
}

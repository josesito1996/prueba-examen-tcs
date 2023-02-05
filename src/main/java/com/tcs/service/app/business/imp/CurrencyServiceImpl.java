package com.tcs.service.app.business.imp;

import static com.tcs.service.app.business.util.Utils.targetAmount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.service.app.business.CurrencyService;
import com.tcs.service.app.business.ExchangeRateService;
import com.tcs.service.app.exception.BadRequestException;
import com.tcs.service.app.expose.request.ExchangeRateRequest;
import com.tcs.service.app.expose.response.ExchangeRateResponse;

import reactor.core.publisher.Mono;

@Service
public class CurrencyServiceImpl implements CurrencyService {

	@Autowired
	private ExchangeRateService exchangeRateService;
	
	@Override
	public Mono<ExchangeRateResponse> transformCurrency(ExchangeRateRequest exchangeRateRequest) {
		
		return exchangeRateService
				.findByExchangeRateCurrency(exchangeRateRequest.getCurrencyOrigin())
				.flatMap(exchangeRateOrigin -> {
					return exchangeRateService
							.findByExchangeRateCurrency(exchangeRateRequest.getDestinationCurrency())
							.map(exchangeRateDestination -> {
								return ExchangeRateResponse.builder()
										.currencyOrigin(exchangeRateOrigin.getExchangeRateCurrency())
										.destinationCurrency(exchangeRateDestination.getExchangeRateCurrency())
										.sourceAmount(exchangeRateRequest.getAmount())
										.destinationAmount(targetAmount(exchangeRateRequest.getAmount(), 
												exchangeRateDestination.getCalculationValue(), 
												exchangeRateOrigin.getCalculationValue()))
										.build();
							})
							.switchIfEmpty(Mono.error(new BadRequestException("No se encontro moneda con el monto de destino")));
				})
				.switchIfEmpty(Mono.error(new BadRequestException("No se encontró moneda con el monto de origen")));
	}

}

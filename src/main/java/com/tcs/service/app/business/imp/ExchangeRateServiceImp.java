package com.tcs.service.app.business.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.service.app.business.ExchangeRateService;
import com.tcs.service.app.business.processor.ExchangeRateResponseProcessor;
import com.tcs.service.app.entity.ExchangeRateEntity;
import com.tcs.service.app.exception.BadRequestException;
import com.tcs.service.app.expose.response.ExchangeRateResponse;
import com.tcs.service.app.repository.ExchangeRateRepository;
import com.tcs.service.app.repository.GenericRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ExchangeRateServiceImp extends CrudGenericImpl<ExchangeRateEntity, Integer>
		implements ExchangeRateService {

	@Autowired
	private ExchangeRateRepository exchangeRateRepository;

	@Autowired
	private ExchangeRateResponseProcessor exchangeRateResponseProcessor;

	@Override
	protected GenericRepository<ExchangeRateEntity, Integer> getGenericRepository() {
		return exchangeRateRepository;
	}

	@Override
	public Flux<Integer> saveAllCustom(List<ExchangeRateEntity> exchangeRateEntities) {

		return exchangeRateRepository
				.saveAll(exchangeRateEntities)
				.map(ExchangeRateEntity::getIdExchange);
	}

	@Override
	public Flux<ExchangeRateResponse> listAllCustom() {

		return exchangeRateRepository
				.findAll()
				.map(exchangeRateResponseProcessor::toExchangeRateResponse);
	}

	@Override
	public Mono<ExchangeRateEntity> findByExchangeRateCurrency(String exchangeRateCurrency) {

		return exchangeRateRepository
				.findByExchangeRateCurrency(exchangeRateCurrency)
				.switchIfEmpty(Mono
						.error(new BadRequestException("Tipo de cambio : " + exchangeRateCurrency + " no existe")));
	}

}

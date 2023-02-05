package com.tcs.service.app.expose.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ExchangeRateResponse implements Serializable {

	private static final long serialVersionUID = -4827099817254783587L;

	private String currencyOrigin;

	private Double sourceAmount;

	private String destinationCurrency;

	private Double destinationAmount;

}

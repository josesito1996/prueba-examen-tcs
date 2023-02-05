package com.tcs.service.app.expose.request;

import java.io.Serializable;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
public class ExchangeRateRequest implements Serializable {

	private static final long serialVersionUID = -183965670379413795L;
	
	@NotNull(message = "no debe ser nulo")
	@NotEmpty(message = "no debe estar vacio")
	private String currencyOrigin;
	
	@NotNull(message = "no debe ser nulo")
	private Double amount;

	@NotNull(message = "no debe ser nulo")
	@NotEmpty(message = "no debe estar vacio")
	private String destinationCurrency;
}

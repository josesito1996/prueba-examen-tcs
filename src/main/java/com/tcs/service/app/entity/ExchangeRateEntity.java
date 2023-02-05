package com.tcs.service.app.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Builder
@Getter
@NoArgsConstructor
@Setter
@Table(name = "exchange_rate")
@ToString
public class ExchangeRateEntity implements Serializable {

	private static final long serialVersionUID = 2020162055738154262L;

	@Id
	@Column
	private Integer idExchange;

	private String exchangeRateCurrency;

	private Double calculationValue;

	private Boolean isActive;

}

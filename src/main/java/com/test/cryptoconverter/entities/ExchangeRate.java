package com.test.cryptoconverter.entities;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
public class ExchangeRate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "currency_code", unique = true, nullable = false, length = 3)
	private String currencyCode;

	@Column(nullable = false, precision = 32, scale = 18)
	private BigDecimal rate;

	public ExchangeRate() {
	}

	public Long getId() {
		return id;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

}

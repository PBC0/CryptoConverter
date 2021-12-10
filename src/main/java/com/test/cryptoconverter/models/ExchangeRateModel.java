package com.test.cryptoconverter.models;

import java.math.BigDecimal;


public class ExchangeRateModel {
	
    private Long id;

    private String currencyCode;

    private BigDecimal rate;

    public ExchangeRateModel() {
    }

    public ExchangeRateModel(String currencyCode, BigDecimal rate) {
        this.currencyCode = currencyCode;
        this.rate = rate;
    }

    public ExchangeRateModel(Long id, String currencyCode, BigDecimal rate) {
        this.id = id;
        this.currencyCode = currencyCode;
        this.rate = rate;
    }

    public String getCurrencyCode() {
		return currencyCode;
	}

	public BigDecimal getRate() {
		return rate;
	}

}

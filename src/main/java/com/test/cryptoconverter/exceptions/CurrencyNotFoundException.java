package com.test.cryptoconverter.exceptions;

public class CurrencyNotFoundException extends Exception {


	private final String currencyCode;

	public CurrencyNotFoundException(String currencyCode) {
        this.currencyCode = currencyCode;
    }

	public String getCurrencyCode() {
		return currencyCode;
	}
}

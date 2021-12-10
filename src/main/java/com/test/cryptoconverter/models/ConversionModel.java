package com.test.cryptoconverter.models;

import java.math.BigDecimal;

public class ConversionModel {
	private String from;
	private String to;
	private BigDecimal amount;
	private BigDecimal totalAmountCalculated;
	
	public ConversionModel(String from, String to, BigDecimal amount, BigDecimal totalAmountCalculated) {
		this.from = from;
		this.to = to;
		this.amount = amount;
		this.totalAmountCalculated = totalAmountCalculated;
	}


	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}


	public BigDecimal getTotalCalculatedAmount() {
		return totalAmountCalculated;
	}


}

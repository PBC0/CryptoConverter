package com.test.cryptoconverter.controllers;

import com.test.cryptoconverter.models.ExchangeRateModel;
import com.test.cryptoconverter.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping()
public class ExchangeRatesController {

	@Autowired
	private ExchangeRateService exchangeRateService;


	//GET ALL EXCHANGE RATES
	@GetMapping(path = "/exchangerates")
	public ResponseEntity<List<ExchangeRateModel>> listExchangeRates() {
		return ResponseEntity.ok(exchangeRateService.listExchangeRates());
	}
}

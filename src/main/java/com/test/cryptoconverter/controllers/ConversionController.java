package com.test.cryptoconverter.controllers;

import com.test.cryptoconverter.exceptions.CurrencyNotFoundException;
import com.test.cryptoconverter.models.ConversionModel;
import com.test.cryptoconverter.service.CurrencyConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.math.BigDecimal;

@RestController
@RequestMapping()
public class ConversionController {

	@Autowired
	private CurrencyConversionService currencyConversionService;


	//CONVERT CURRENCY FROM TO
	@GetMapping("/convert/{from}/{to}")
	public ResponseEntity<BigDecimal> convertCurrency(@RequestParam BigDecimal amount, @PathVariable String from, @PathVariable String to) {
		ConversionModel model;
		try {
			model = currencyConversionService.convertCurrency(amount, from, to);
		} catch (CurrencyNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getLocalizedMessage(), e);
		}
		return ResponseEntity.ok(model.getTotalCalculatedAmount());
	}

}

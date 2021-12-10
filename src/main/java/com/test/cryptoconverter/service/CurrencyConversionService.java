package com.test.cryptoconverter.service;


import com.test.cryptoconverter.exceptions.CurrencyNotFoundException;
import com.test.cryptoconverter.models.ConversionModel;
import com.test.cryptoconverter.models.ExchangeRateModel;
import com.test.cryptoconverter.util.CsvReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CurrencyConversionService {
    @Autowired
    private ExchangeRateService exchangeRateService;


    // Loads rates.csv file as a PostConstruct on application start.
    @PostConstruct
    public ResponseEntity<List<ExchangeRateModel>> importCSV() {
            try (Reader reader = new BufferedReader(new
                    InputStreamReader(getClass().getClassLoader().getResourceAsStream("rates.csv")))) {
                final Stream<ExchangeRateModel> stream = CsvReader.readExchangeRates(reader);
                final List<ExchangeRateModel> exchangeRates = stream
                        .map(model -> exchangeRateService.ExchangeRate(model)).collect(Collectors.toList());
                return ResponseEntity.ok(exchangeRates);
            } catch (Exception e) {
                throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getLocalizedMessage(), e);
            }
        }
    
    public ConversionModel convertCurrency(BigDecimal fromAmount, String from, String to) throws CurrencyNotFoundException {
    	final ExchangeRateModel fromModel = exchangeRateService.findByCurrencyCode(from);
    	final ExchangeRateModel toModel = exchangeRateService.findByCurrencyCode(to);
    	return new ConversionModel(from, to, fromAmount, fromAmount.multiply(fromModel.getRate()).divide(toModel.getRate(), 18, RoundingMode.HALF_DOWN));
    }

}

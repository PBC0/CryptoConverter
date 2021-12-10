package com.test.cryptoconverter.service;


import com.test.cryptoconverter.entities.ExchangeRate;
import com.test.cryptoconverter.exceptions.CurrencyNotFoundException;
import com.test.cryptoconverter.models.ExchangeRateModel;
import com.test.cryptoconverter.repository.ExchangeRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExchangeRateService {
    @Autowired
    private ExchangeRateRepository exchangeRateRepository;

    public List<ExchangeRateModel> listExchangeRates() {
        List<ExchangeRate> exchangeRateList = exchangeRateRepository.findAll();
        return exchangeRateList.stream().map(ExchangeRateService::assembleExchangeRateModel).collect(Collectors.toList());
    }

     // OPTION TO CHANGE RATES ON THE GO IN FUTURE IF NEEDED TODO
    public ExchangeRateModel ExchangeRate(ExchangeRateModel exchangeRateModel) {
        ExchangeRate exchangeRateEntity;
    	final String currencyCode = exchangeRateModel.getCurrencyCode();
        exchangeRateEntity = new ExchangeRate();
        exchangeRateEntity.setCurrencyCode(currencyCode);
        exchangeRateEntity.setRate(exchangeRateModel.getRate());
        ExchangeRate current= exchangeRateRepository.save(exchangeRateEntity);
        return assembleExchangeRateModel(current);
    }

    public ExchangeRateModel findByCurrencyCode(String currencyCode) throws CurrencyNotFoundException {
        ExchangeRateModel exchangeRateModel = null;
        Optional<ExchangeRate> exchangeRateEntity = exchangeRateRepository.findByCurrencyCode(currencyCode);
        if (exchangeRateEntity.isPresent()) {
            ExchangeRate current = exchangeRateEntity.get();
            exchangeRateModel = assembleExchangeRateModel(current);
        }
        else {
    		throw new CurrencyNotFoundException(currencyCode);
        }
        return exchangeRateModel;
    }

    private static ExchangeRateModel assembleExchangeRateModel(ExchangeRate exchangeRateEntity) {
        return new ExchangeRateModel(exchangeRateEntity.getId(), exchangeRateEntity.getCurrencyCode(), exchangeRateEntity.getRate().stripTrailingZeros());
    }
}

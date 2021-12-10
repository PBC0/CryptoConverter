package com.test.cryptoconverter.util;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.test.cryptoconverter.models.ExchangeRateModel;

import java.io.Reader;
import java.util.stream.Stream;

public class CsvReader {

	private CsvReader() {
	}

	public static Stream<ExchangeRateModel> readExchangeRates(Reader reader) {
        ColumnPositionMappingStrategy<ExchangeRateModel> mapStrategy
		        = new ColumnPositionMappingStrategy<>();

		mapStrategy.setType(ExchangeRateModel.class);

		String[] columns = new String[]{"currencyCode", "rate"};
		mapStrategy.setColumnMapping(columns);

		CsvToBean<ExchangeRateModel> csvToBean = new CsvToBeanBuilder<ExchangeRateModel>(reader)
		        .withMappingStrategy(mapStrategy)
		        .withSkipLines(0)
		        .withIgnoreLeadingWhiteSpace(true)
		        .build();
		
		return csvToBean.stream();
    }
}

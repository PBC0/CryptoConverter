package com.test.cryptoconverter.repository;

import com.test.cryptoconverter.entities.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {
	Optional<ExchangeRate> findByCurrencyCode(String currencyCode);
}

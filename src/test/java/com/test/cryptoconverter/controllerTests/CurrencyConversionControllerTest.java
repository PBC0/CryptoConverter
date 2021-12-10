package com.test.cryptoconverter.controllerTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
class CurrencyConversionControllerTest {

    @Autowired
	private TestRestTemplate template;

	@Test
    void testConvertCurrency()
    {
        ResponseEntity<BigDecimal> response = template.getForEntity("/convert/{from}/{to}?amount={amount}", BigDecimal.class, "EUR", "USD", 700);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());                      //STATUS TEST
        Assertions.assertEquals(18, response.getBody().scale());                      //SCALE CHECK
		Assertions.assertEquals(864.675000129268912519,response.getBody().doubleValue()); //MATH CHECK
    }
}

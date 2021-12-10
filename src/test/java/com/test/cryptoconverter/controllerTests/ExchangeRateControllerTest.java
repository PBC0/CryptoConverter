package com.test.cryptoconverter.controllerTests;


import com.test.cryptoconverter.models.ExchangeRateModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
class ExchangeRatesControllerTest {

    @Autowired
	private TestRestTemplate template;

    @BeforeEach
	void setUp() throws Exception {
    	Assertions.assertNotNull(template);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
    void testExchangeRates()
    {
		ResponseEntity<ExchangeRateModel[]> resultList = template.getForEntity("/exchangerates", ExchangeRateModel[].class);
		Assertions.assertEquals(HttpStatus.OK, resultList.getStatusCode());
		Assertions.assertTrue(resultList.getBody().length > 0);
    }

}

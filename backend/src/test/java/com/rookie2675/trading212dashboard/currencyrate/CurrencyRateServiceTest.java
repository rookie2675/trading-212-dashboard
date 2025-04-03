package com.rookie2675.trading212dashboard.currencyrate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CurrencyRateServiceTest {

    @Autowired
    CurrencyRateService service;

    @Test
    public void testConnection() {
        String baseCurrency = "EUR";
        String[] targetCurrencies = {"USD", "CAD", "BRL"};
        Map<String, Double> response = service.fetch(baseCurrency, targetCurrencies);
        assertNotNull(response);
    }
}

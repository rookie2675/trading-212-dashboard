package com.rookie2675.trading212dashboard;

import com.rookie2675.trading212dashboard.currencyrate.CurrencyRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class InitializationRunner implements ApplicationRunner {

    private final CurrencyRateService currencyRateService;

    @Autowired
    public InitializationRunner(CurrencyRateService currencyRateService) {
        this.currencyRateService = currencyRateService;
    }

    @Override
    public void run(ApplicationArguments args) {
        String baseCurrency = "EUR";
        String[] targetCurrencies = {"USD", "CAD"};
        Map<String, Double> currencies = currencyRateService.fetch(baseCurrency, targetCurrencies);
        System.out.println(currencies);
    }
}

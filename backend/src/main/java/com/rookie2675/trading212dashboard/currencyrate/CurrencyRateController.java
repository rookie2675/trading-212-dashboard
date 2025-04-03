package com.rookie2675.trading212dashboard.currencyrate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController()
@RequestMapping("/currency-rate")
public class CurrencyRateController {

    private final CurrencyRateService service;

    @Autowired
    public CurrencyRateController(CurrencyRateService service) {
        this.service = service;
    }

    @GetMapping
    public Map<String, Double> get(@RequestParam String baseCurrency, @RequestParam String[] targetCurrencies) {
        return service.fetch(baseCurrency, targetCurrencies);
    }
}

package com.rookie2675.trading212dashboard;

import com.rookie2675.trading212dashboard.currencyrate.CurrencyRateService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication
public class Trading212DashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(Trading212DashboardApplication.class, args);
		Map<String, Double> exchangeRates = getExchangeRates();
		System.out.println(exchangeRates);
	}

	public static Map<String, Double> getExchangeRates() {
		CurrencyRateService service = new CurrencyRateService();
		String baseCurrency = "EUR";
		String[] targetCurrencies = {"USD", "CAD"};
		return service.fetch(baseCurrency, targetCurrencies);
	}
}

package com.rookie2675.trading212dashboard.currencyrate;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

public class CurrencyRateService {
    private final RestTemplate restTemplate;
    private static final String URL = "https://api.freecurrencyapi.com/v1/latest";

    public CurrencyRateService() {
        this.restTemplate = new RestTemplate();
    }

    public Map<String, Double> fetch(String baseCurrency, String[] targetCurrencies) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL)
                .queryParam("base_currency", baseCurrency)
                .queryParam("currencies", String.join(",", targetCurrencies))
                .queryParam("apikey", "");

        CurrencyRateApiResponse response = restTemplate.getForObject(builder.toUriString(), CurrencyRateApiResponse.class);
        return response.getData();
    }
}

package com.rookie2675.trading212dashboard.currencyrate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Service
public class CurrencyRateService {

    @Value("${app.security.free-currency-api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    private static final String URL = "https://api.freecurrencyapi.com/v1/latest";

    public CurrencyRateService() {
        this.restTemplate = new RestTemplate();
    }

    public Map<String, Double> fetch(String baseCurrency, String[] targetCurrencies) {
        String uriString = buildUriString(baseCurrency, targetCurrencies);
        CurrencyRateApiResponse response = restTemplate.getForObject(uriString, CurrencyRateApiResponse.class);
        return response.getData();
    }

    private String buildUriString(String baseCurrency, String[] targetCurrencies) {
        return UriComponentsBuilder.fromHttpUrl(URL)
                .queryParam("base_currency", baseCurrency)
                .queryParam("currencies", String.join(",", targetCurrencies))
                .queryParam("apikey", apiKey)
                .toUriString();
    }
}

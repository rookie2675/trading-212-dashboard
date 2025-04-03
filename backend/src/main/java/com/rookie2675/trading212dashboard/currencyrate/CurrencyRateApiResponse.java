package com.rookie2675.trading212dashboard.currencyrate;

import java.util.Map;

public record CurrencyRateApiResponse(Map<String, Double> data) { }

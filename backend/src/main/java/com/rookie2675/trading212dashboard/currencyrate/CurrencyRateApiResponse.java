package com.rookie2675.trading212dashboard.currencyrate;

import java.util.Map;

public class CurrencyRateApiResponse {
    private Map<String, Double> data;

    public Map<String, Double> getData() {
        return data;
    }

    public void setData(Map<String, Double> data) {
        this.data = data;
    }
}

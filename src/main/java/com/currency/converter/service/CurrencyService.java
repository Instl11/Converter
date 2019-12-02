package com.currency.converter.service;

import com.currency.converter.domen.Currency;
import com.currency.converter.domen.CurrencyMap;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class CurrencyService {

    private RestTemplate restTemplate;

    public CurrencyService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Map<String, Currency> getCurrencies() {

        CurrencyMap map =
                restTemplate.getForObject("https://www.cbr-xml-daily.ru/daily_json.js", CurrencyMap.class);

        return map.getCurrencyMap();

    }
}

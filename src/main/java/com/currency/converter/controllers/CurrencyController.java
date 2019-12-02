package com.currency.converter.controllers;

import com.currency.converter.domen.Currency;
import com.currency.converter.domen.CurrencyMap;
import com.currency.converter.domen.SelectedCurrency;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller(value = "exchange")
public class CurrencyController {

    private RestTemplate restTemplate;

    public CurrencyController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public String start(Model model) {
        model.addAttribute("dollar", "USD");
        model.addAttribute("euro", "EUR");
        model.addAttribute("crown", "GBP");
        model.addAttribute("result", 0.0);
        model.addAttribute("wrapper", new SelectedCurrency());
        return "currency";
    }

    @PostMapping
    public String exchange(SelectedCurrency c, int amount, Model model)  {

        MappingJackson2HttpMessageConverter converter =
                new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        restTemplate.getMessageConverters().add(converter);

        CurrencyMap mapWrapper =
                restTemplate.getForObject("https://www.cbr-xml-daily.ru/daily_json.js", CurrencyMap.class);

        Map<String, Currency> currencyMap = mapWrapper.getCurrencyMap();

        String cur = c.getCurrency();
        Currency currency = currencyMap.get(cur);

        double rate = currency.getValue();
        double result = Math.round(amount/rate*100)/100.0;
        model.addAttribute("result", result);

        return "result";
    }
}

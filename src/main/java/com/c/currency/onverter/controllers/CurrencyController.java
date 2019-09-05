package com.c.currency.onverter.controllers;

import com.c.currency.onverter.domen.Currency;
import com.c.currency.onverter.domen.CurrenciesRate;
import com.c.currency.onverter.domen.ParserCurrency;
import com.c.currency.onverter.repositories.CurrencyRepo;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.util.List;

@Controller
public class CurrencyController {

    @Autowired
    CurrencyRepo currencyRepo;

    @GetMapping
    public String start(Model model) {

        model.addAttribute("dollar", Currency.DOLLAR);
        model.addAttribute("euro", Currency.EURO);
        model.addAttribute("crown", Currency.GBP);
        model.addAttribute("result", 0.0);

        return "currency";
    }


    @PostMapping
    public String exchange(@ModelAttribute CurrenciesRate currency, int amount, Model model) throws IOException {

        Currency selectedCur = currency.getCurrency();
        List<CurrenciesRate> currenciesRate = ParserCurrency.getCurrenciesRate();
        currencyRepo.deleteAll();
        currencyRepo.saveAll(currenciesRate);

        CurrenciesRate currencyRate = currencyRepo.findByCurrency(selectedCur);
        double rate = currencyRate.getRate();
        double result = Math.round(amount/rate*100)/100.0;
        model.addAttribute("result", result);

        return "result";
    }


}

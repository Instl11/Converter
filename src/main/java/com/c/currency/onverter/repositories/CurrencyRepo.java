package com.c.currency.onverter.repositories;

import com.c.currency.onverter.domen.CurrenciesRate;
import com.c.currency.onverter.domen.Currency;
import org.springframework.data.repository.CrudRepository;

public interface CurrencyRepo extends CrudRepository<CurrenciesRate, Integer> {

    CurrenciesRate findByCurrency(Currency currency);

}

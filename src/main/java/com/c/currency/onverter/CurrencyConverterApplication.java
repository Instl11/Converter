package com.c.currency.onverter;

import com.c.currency.onverter.domen.ParserCurrency;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class CurrencyConverterApplication {

	public static void main(String[] args) throws IOException {
		//ParserCurrency.getCurrenciesRate("https://www.banki.ru/products/currency/");

		SpringApplication.run(CurrencyConverterApplication.class, args);


	}

}

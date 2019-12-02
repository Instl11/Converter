package com.currency.converter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@SpringBootApplication
public class CurrencyConverterApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(CurrencyConverterApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
		return new RestTemplate();
    }

}

package com.currency.converter;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest
public class CurrencyConverterApplicationTests {

	@Autowired
    private MockMvc mockMvc;

	@Test
    public void testStartPage() throws Exception {
	    mockMvc.perform(MockMvcRequestBuilders.get("exchange"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("currency"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("Выберите валюту для обмена")));
    }

}

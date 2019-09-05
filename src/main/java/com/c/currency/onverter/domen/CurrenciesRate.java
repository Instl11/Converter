package com.c.currency.onverter.domen;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class CurrenciesRate {

    @Id
    @GeneratedValue
    private int id;

    @NonNull
    @Enumerated(value = EnumType.STRING)
    private Currency currency;

    @NonNull
    private double rate;


}

package com.atm.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Atm {

    private BigDecimal moneyLimit;


    @Override
    public String toString() {
        return "ATM { " +
                ", money limit=" + moneyLimit +
                '}';
    }
}

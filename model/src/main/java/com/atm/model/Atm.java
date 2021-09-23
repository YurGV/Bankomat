package com.atm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

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

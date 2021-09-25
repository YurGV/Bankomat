package com.atm.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card implements Serializable {

    private String cardNumber;
    private BigDecimal balance;
    private String pinCode;
    private Boolean cardLockStatus;
    private Calendar dateLockCard;

    @Override
    public String toString() {
        return "Card { " +
                " card number = " + cardNumber +
                ", balance = " + balance +
                ", pin code = " + pinCode +
                ", card lock status = " + cardLockStatus +
                ", date of lock card = " + dateLockCard +
                '}';
    }
}

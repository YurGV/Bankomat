package com.atm.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
public class Card implements Serializable {

    private String cardNumber;
    private BigDecimal balance;
    private String pinCode;
    private Boolean cardLockStatus;
    private Date dateLockCard;

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

package com.atm.api.service;


import com.atm.model.Atm;
import com.atm.model.Card;


import java.math.BigDecimal;
import java.util.Calendar;

public interface CardService {

    void viewBalance(Card card);
    void withdrawalCash(Card card, BigDecimal summa, Atm atm);
    void balanceReplenishment(Card card, BigDecimal summa);
    void checkPinCode(Integer pinCode);
    void cardLock(Boolean cardLock);
    void saveLockData(Calendar dataLock);

}

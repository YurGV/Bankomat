package com.atm.api.service;


import com.atm.model.Atm;
import com.atm.model.Card;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Calendar;

public interface CardService {

    void viewBalance(Card card);
    void withdrawalCash(Card card, BigDecimal summa, Atm atm);
    void balanceReplenishment(Card card, BigDecimal summa);
    Boolean checkPinCode(Card card) throws IOException;
    Boolean checkStatusCard(Card card);
    Boolean checkNumberCard(Card card) throws IOException;
    void saveLockData(Calendar dataLock);

}

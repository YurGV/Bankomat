package com.atm.api.service;


import com.atm.models.Atm;
import com.atm.models.Card;

import java.io.IOException;
import java.math.BigDecimal;


public interface CardService {

    void viewBalance(Card card);
    void withdrawalCash(Card card, BigDecimal summa, Atm atm);
    void balanceReplenishment(Card card, BigDecimal summa);
    Boolean checkPinCode(Card card) throws IOException;
    Boolean checkStatusCard(Card card);
    Boolean checkNumberCard(Card card) throws IOException;

}

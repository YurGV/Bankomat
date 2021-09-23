package com.atm.service;

import com.atm.api.service.CardService;
import com.atm.model.Card;


import javax.xml.crypto.Data;

import java.math.BigDecimal;

public class CardServiceImpl implements CardService {
    @Override
    public Card viewBalance(String cardNumber) {

        return null;
    }

    @Override
    public void withdrawalCash(BigDecimal quantity) {

    }

    @Override
    public void balanceReplenishment(BigDecimal quantity) {

    }

    @Override
    public void checkPinCode(Integer pinCode) {


    }

    @Override
    public void cardLock(Boolean cardLock) {

    }

    @Override
    public void saveLockData(Data dataLock) {

    }
}

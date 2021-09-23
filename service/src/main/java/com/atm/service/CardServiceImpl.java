package com.atm.service;

import com.atm.api.service.CardService;
import com.atm.model.Atm;
import com.atm.model.Card;


import javax.xml.crypto.Data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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



    public static void withdrawalCash(Card card1, BigDecimal summa, Atm atm) throws IOException {
        //проверка средств на карте и лимита в банкомате, снятие наличных
        if ((atm.getMoneyLimit().compareTo(summa) >= 0) && (card1.getBalance().compareTo(summa) >= 0) ) {
            card1.setBalance(card1.getBalance().subtract(summa));
            System.out.println("Операция прошла успешно");
            System.out.println("Остаток средств на карте: " + card1.getBalance());
        }
        else System.out.println("Сумма недоступна");
    }

    public static void balanceReplenishment(Card card1, BigDecimal summa) throws IOException {
        //проверка лимита при пополнении счёта и пополнение
        if (summa.compareTo(BigDecimal.valueOf(1000000.00)) <= 0)  {
            card1.setBalance(card1.getBalance().add(summa));
            System.out.println("Операция прошла успешно");
            System.out.println("Остаток средств на карте: " + card1.getBalance());
        }
        else System.out.println("Сумма недоступна");
    }
}

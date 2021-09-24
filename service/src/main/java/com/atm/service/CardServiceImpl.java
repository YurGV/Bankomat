package com.atm.service;

import com.atm.api.service.CardService;
import com.atm.model.Atm;
import com.atm.model.Card;

import java.math.BigDecimal;
import java.util.Calendar;

public class CardServiceImpl implements CardService {
    @Override
    public  void viewBalance(Card card) {
        System.out.println("Баланс вашей карты составляет: " + card.getBalance());

    }

    @Override
    public  void withdrawalCash(Card card, BigDecimal summa, Atm atm) {
       // проверка средств на карте и лимита в банкомате, снятие наличных
        if ((atm.getMoneyLimit().compareTo(summa) >= 0) && (card.getBalance().compareTo(summa) >= 0) ) {
            card.setBalance(card.getBalance().subtract(summa));
            System.out.println("Операция прошла успешно");
            System.out.println("Остаток средств на карте: " + card.getBalance());
        }
        else System.out.println("Сумма недоступна");
    }

    @Override
    public void balanceReplenishment(Card card, BigDecimal summa) {
        //проверка лимита при пополнении счёта и пополнение
        if (summa.compareTo(BigDecimal.valueOf(1000000.00)) <= 0)  {
            card.setBalance(card.getBalance().add(summa));
            System.out.println("Операция прошла успешно");
            System.out.println("Остаток средств на карте: " + card.getBalance());
        }
        else System.out.println("Сумма недоступна");
    }

    @Override
    public void checkPinCode(Integer pinCode) {

    }

    @Override
    public void cardLock(Boolean cardLock) {

    }

    @Override
    public void saveLockData(Calendar dataLock) {

    }


}

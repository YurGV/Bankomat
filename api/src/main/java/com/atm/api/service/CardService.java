package com.atm.api.service;


import com.atm.model.Card;

import javax.xml.crypto.Data;
import java.math.BigDecimal;

public interface CardService {

    Card viewBalance(String cardNumber);
    void withdrawalCash (BigDecimal quantity);
    void balanceReplenishment (BigDecimal quantity);
    void checkPinCode(Integer pinCode);
    void cardLock(Boolean cardLock);
    void saveLockData(Data dataLock);

}

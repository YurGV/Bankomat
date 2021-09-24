package com.atm.service;

import com.atm.api.service.AtmService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;


public class AtmServiceImpl implements AtmService {

    //сумма которую мы хотим положить на счёт
    public static BigDecimal inputBalanceReplenishment() throws IOException {
        BigDecimal summa;
        System.out.print("Введите сумму для пополнения счёта: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sum = reader.readLine();
        summa = BigDecimal.valueOf(Double.parseDouble(sum));
        System.out.println(summa);
        return summa;
    }

    //сумма которую мы хотим снять
    public static BigDecimal inputWithdrawalCash() throws IOException {
        BigDecimal summa;
        System.out.print("Введите сумму для выдачи наличных: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sum = reader.readLine();
        summa = BigDecimal.valueOf(Double.parseDouble(sum));
        System.out.println(summa);
        return summa;
    }
}

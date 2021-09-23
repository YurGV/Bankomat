package com.atm;


import com.atm.model.Atm;
import com.atm.model.Card;
import com.atm.service.AtmServiceImpl;
import com.atm.service.CardServiceImpl;


import java.io.*;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

//        Card card = new Card("1234-5678-0011-9910", BigDecimal.valueOf(5000.05), "0123", false, new Date(1212121212121L));
//
//
//        FileInputStream inputStream = new FileInputStream("e:/data.txt");
//        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date = new Date(1212121212131L);
//        System.out.println(date);
//        System.out.println(formater.format(date));
//        System.out.println(card);
//        System.out.println(card.getDateLockCard());
//        System.out.println(card.getBalance());

//        serialization(card);

        System.out.println("проверка ---------------------- ");
        Card card1 = deserialization();
        System.out.println(card1);
        BigDecimal summa = BigDecimal.valueOf(333.3);

        //сумма в банкомате
        Atm atm = new Atm();
        atm.setMoneyLimit(BigDecimal.valueOf(5500.05));
        //inputWithdrawalCash(summa);
        CardServiceImpl cardService = new CardServiceImpl();
        AtmServiceImpl atmService = new AtmServiceImpl();
        summa = AtmServiceImpl.inputWithdrawalCash();
        CardServiceImpl.withdrawalCash(card1, summa, atm);
        summa = AtmServiceImpl.inputBalanceReplenishment();
        CardServiceImpl.balanceReplenishment(card1,summa);


    }


    private static void serialization(Card card) throws IOException {
        //FileOutputStream outputStream = new FileOutputStream("E:\\save.ser");
        FileOutputStream outputStream = new FileOutputStream("E:\\save.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        // сохраняем данные в файл
        objectOutputStream.writeObject(card);
        //закрываем поток и освобождаем ресурсы
        objectOutputStream.close();
        System.out.println("*** Data saved");
    }

    private static Card deserialization() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("E:\\save.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        System.out.println("*** Data recovered");
        return (Card) objectInputStream.readObject();

    }


}

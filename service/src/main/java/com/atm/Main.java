package com.atm;


import com.atm.api.service.CardService;
import com.atm.model.Atm;
import com.atm.model.Card;
import com.atm.service.AtmServiceImpl;
import com.atm.service.CardServiceImpl;


import java.io.*;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {
    public static <currentTime> void main(String[] args) throws IOException, ClassNotFoundException {


        Card card = new Card("1234-5678-0011-9910", BigDecimal.valueOf(5000.05), "0123", false, new GregorianCalendar(2021, 8, 23) {});
//
//
//        FileInputStream inputStream = new FileInputStream("e:/data.txt");
//        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date = new Date(1212121212131L);
//        System.out.println(date);
//        System.out.println(formater.format(date));
//        System.out.println(card);
//        System.out.println(card.getDateLockCard());
//        System.out.println(card.getBalance())
//     serialization(card);
//


//        System.out.println("проверка ---------------------- ");
//        card = deserialization();
//        System.out.println(card);
//        BigDecimal summa = BigDecimal.valueOf(333.3);

//        //сумма в банкомате
//        Atm atm = new Atm();
//        atm.setMoneyLimit(BigDecimal.valueOf(5500.05));
//
        CardServiceImpl cardService = new CardServiceImpl();
//        AtmServiceImpl atmService = new AtmServiceImpl();
//
//        if (checkNumberCard(card) && (cardService.checkPinCode(card))) {
//            System.out.println("oooooookkk!");
//
//        }

        //card.setCardLockStatus(true);
        //проверка pin

        System.out.println("Lock status is " + card.getCardLockStatus());

        System.out.println("Date " + card.getDateLockCard());

        System.out.println("---------------------------------");


       if (cardService.checkStatusCard(card)) {
           System.out.println("*********************  Stop ****************************");
       }
       else {
           System.out.println(" ******************* GO ****************************");
           if ((cardService.checkNumberCard(card) && (cardService.checkPinCode(card)))) {
           System.out.println("oooooookkk!");
               System.out.println("Снять деньги ---> ");
        }
       }

        //работает
//        summa = atmService.inputWithdrawalCash();
//        cardService.withdrawalCash(card, summa, atm);
//
//        summa = atmService.inputBalanceReplenishment();
//        cardService.balanceReplenishment(card,summa);
//
//        cardService.viewBalance(card);

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

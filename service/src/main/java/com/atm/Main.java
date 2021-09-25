package com.atm;


import com.atm.api.service.CardService;
import com.atm.model.Atm;
import com.atm.model.Card;
import com.atm.service.AtmServiceImpl;
import com.atm.service.CardServiceImpl;


import java.io.*;
import java.math.BigDecimal;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {
    public static <currentTime> void main(String[] args) throws IOException, ClassNotFoundException {


//        Card card = new Card("1234-5678-0011-9910", BigDecimal.valueOf(5000.05), "0123", false, new GregorianCalendar(2021, 8, 23) {});
 //       Card card = new Card("1234-5678-0011-9910", BigDecimal.valueOf(5000.05), "0123", true, new GregorianCalendar(2021, 8, 24) {});

        CardServiceImpl cardService = new CardServiceImpl();
        AtmServiceImpl atmService = new AtmServiceImpl();
        Atm atm = new Atm();
        atm.setMoneyLimit(BigDecimal.valueOf(5500.05)); //сумма в банкомате
        BigDecimal summa;
        Card card;

       card = new Card("1234-5678-0011-9910", BigDecimal.valueOf(5000.05), "0123", true, new GregorianCalendar(2021, 8, 24) {});

       start(cardService, atmService, atm, card);


      //  mainMenu(cardService, atmService, atm, card);


    }

    private static void mainMenu(CardServiceImpl cardService, AtmServiceImpl atmService, Atm atm, Card card) throws IOException, ClassNotFoundException {
        BigDecimal summa;
        boolean work = true;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите № операции: ");
            System.out.println("1. Проверить баланс");
            System.out.println("2. Снять наличные");
            System.out.println("3. Пополнить счёт");
            System.out.println("4. Завершить работу");

            int operation = scanner.nextInt();

            switch (operation) {
                case 1:
                    cardService.viewBalance(card);
                    break;

                case 2: {
                    summa = atmService.inputWithdrawalCash();
                    cardService.withdrawalCash(card, summa, atm);
                }
                break;
                case 3: {
                    summa = atmService.inputBalanceReplenishment();
                    cardService.balanceReplenishment(card, summa);
                }
                break;
                case 4: {
                    work = false;
                }
                break;
                default:
                    System.out.println("Вы ввели неправильный номер. Выберите пункт:");
            }
            if (work) {
                mainMenu(cardService, atmService, atm, card);
            }
            else {
                System.out.println("Конец работы!");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void start(CardServiceImpl cardService, AtmServiceImpl atmService, Atm atm, Card card) throws IOException, ClassNotFoundException {
        BigDecimal summa;
        System.out.println(" ******************* Start ****************************");
        card = deserialization();

        if ((cardService.checkNumberCard(card) && (cardService.checkPinCode(card)))) {
            mainMenu(cardService, atmService, atm, card);
            }
        serialization(card);
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

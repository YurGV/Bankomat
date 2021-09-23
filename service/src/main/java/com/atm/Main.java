package com.atm;


import com.atm.model.Atm;
import com.atm.model.Card;


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
        inputWithdrawalCash(summa);
        withdrawalCash(card1, summa, atm);
        inputBalanceReplenishment(summa);
        System.out.println("Останок средств: " + card1.getBalance());

    }

    private static void withdrawalCash(Card card1, BigDecimal summa, Atm atm) throws IOException {
        //проверка средств на карте и лимита в банкомате
        if ((atm.getMoneyLimit().compareTo(summa) >= 0) && (card1.getBalance().compareTo(summa) >= 0) ) {
            card1.setBalance(card1.getBalance().subtract(summa));
            System.out.println("Операция прошла успешно");
            System.out.println("Остаток средств на карте: " + card1.getBalance());
        }
        else System.out.println("Сумма недоступна");

    }


    public static BigDecimal inputWithdrawalCash(BigDecimal summa) throws IOException {
        //сумма которую мы хотим снять
        System.out.print("Введите сумму для выдачи наличных: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sum = reader.readLine();
        return BigDecimal.valueOf(Double.parseDouble(sum));
    }

    public static BigDecimal inputBalanceReplenishment(BigDecimal summa) throws IOException {
        //сумма которую мы хотим положить на счёт
        System.out.print("Введите сумму для пополнения счёта: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sum = reader.readLine();
        return BigDecimal.valueOf(Double.parseDouble(sum));
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

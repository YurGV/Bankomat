import com.atm.api.service.CardService;
import com.atm.models.Atm;
import com.atm.models.Card;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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
    //проверка пин-кода и блокировка в случаи 3 неверных попыток
    public Boolean checkPinCode(Card card) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            for (int i = 1; i < 4; i++) {
                System.out.print("Введите PIN-код :");
                String pinCode = reader.readLine();
                if (pinCode.equals(card.getPinCode())) {
                    System.out.println("PIN ok! ");
                    return true;
                } else {
                    System.out.println("Неправильный PIN");
                    if (i == 3) {
                        System.out.println("Ваша карта заблокирована!");
                        card.setCardLockStatus(true);
                        Calendar calendar = new GregorianCalendar();
                        Date date = calendar.getTime();
                        card.setDateLockCard(calendar);
                        System.out.println("Дата блокировки карты: " + date);
                        break;
                    }
                }
            }
        return false;
    }

    @Override
    public Boolean checkNumberCard(Card card) throws IOException {
        if ((card.getCardLockStatus()) && checkStatusCard(card)) {
            System.out.println("GOOD BYE!!!");
        }
        else {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Введите номер карты в формате XXXX-XXXX-XXXX-XXXX : ");
            String number = reader.readLine();
            while (!number.equals("exit")) {
                if (number.equals(card.getCardNumber())) {
                    System.out.println("Номер верный, теперь введите пин");
                    return true;
                } else {
                    System.out.println("Данной карты не существует");
                    System.out.print("Введите иной номер карты или напишите 'exit': ");
                    number = reader.readLine();
                }
            }
        }
        return false;
    }

    @Override
    public Boolean checkStatusCard(Card card) {
        Calendar currentTime = new GregorianCalendar();
        currentTime.add(Calendar.DAY_OF_MONTH, -1);
        if (currentTime.after(card.getDateLockCard())) {
            System.out.println("Card unlock");
            card.setCardLockStatus(false);
            return false;
        }
        else System.out.println("Ваша карта заблокирована! Вы не можете её использовать! Ожидайте 1 день...");
        return true;
    }

}

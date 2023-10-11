package playerPrats;

import exceptions.InvalidInputDataException;
import exceptions.NotEnoughMoneyException;

/**
 *
 *  Класс для хранения баланса и осуществления операций над ним.
 *
 */

public class Balance {
    private float balance;

    public Balance() {
        this.balance = 0;
    }

    public float getBalance() {
        return balance;
    }

    /**
     *
     *  Кредитные транзакции (добавление средств). Принимает число. Если оно положительное - добавляет к балансу.
     *
     */

    public void credit(float input) throws InvalidInputDataException {
        if (input > 0) {
            this.balance += input;
        } else {
            throw new InvalidInputDataException();
        }
    }

    /**
     *
     *  Дебетовые транзакции (удаление средств). Принимает число.
     *  Если оно положительное и меньше или равно сумме на счету - вычитает из баланса.
     *
     */

    public void debit(float output) throws NotEnoughMoneyException, InvalidInputDataException {
        if (output < 0) {
            throw new InvalidInputDataException();
        }
        if (this.balance >= output) {
            this.balance -= output;
        } else {
            throw new NotEnoughMoneyException();
        }
    }

    @Override
    public String toString() {
        return "Balance{" +
                "balance=" + balance +
                '}';
    }
}

package input;

import output.Output;

import java.util.Scanner;

/**
 *
 *  Класс для чтения из консоли.
 *
 */

public class ConsoleInput extends Input{
    private final Scanner in;
    private final Output out;

    /**
     *
     * При создании конструктор запрашивает инструмент для вывода, чтобы уведомить пользователя о вводимом значении.
     *
     */

    public ConsoleInput(Output out) {
        this.in = new Scanner(System.in);
        this.out = out;
    }

    /**
     *
     *  Запрпашивает ввод, до тех пор пока не будет введено число от 1 до maxVar.
     *  Возвращает полученное число.
     *  Для выбора в меню.
     *
     */

    public int getVariants(int maxVar) {
        int num = -1;
        String str;
        while (num < 1 || num > maxVar) {
            out.varInput(maxVar);
            str = in.next();
            try {
                num = Integer.parseInt(str);
            } catch (NumberFormatException e) {
                num = -1;
            }
        }
        return num;
    }

    /**
     *
     *  Ввод суммы транзакций.
     *
     */

    public int getSum() {
        int sum = -1;
        String str;
        while (sum == -1) {
            out.outputString("Введите сумму.");
            str = in.next();
            try {
                sum = Integer.parseInt(str);
            } catch (NumberFormatException e) {
                sum = -1;
            }
        }
        return sum;
    }

    /**
     *
     *  Запрос любого строкового значения. На вход принимает название этого значения. Нопример имя или пароль.
     *
     */

    public String getNamedString(String name) {
        out.strInput(name);
        return in.next();
    }
}

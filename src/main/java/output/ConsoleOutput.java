package output;

/**
 *
 *  Класс консольног вывода.
 *
 */

public class ConsoleOutput extends Output{

    /**
     *
     *  Главное меню.
     *
     */

    public void mainMenu() {
        System.out.println("1) Зарегестрироваться.");
        System.out.println("2) Авторизоваться.");
        System.out.println("3) Запросить аудит.");
        System.out.println("4) Выйти.");
    }

    /**
     *
     *  Меню операций доступных залогининому игроку.
     *
     */

    public void operationMenu() {
        System.out.println("1) Внести деньги.");
        System.out.println("2) Вывести деньги.");
        System.out.println("3) Получить баланс");
        System.out.println("4) Разлогиниться.");
    }

    /**
     *
     *  Запрос номера варианта из меню.
     *
     */

    public void varInput(int maxVar) {
        System.out.printf("Введите номер варианта от 1 до %d\n", maxVar);
    }

    /**
     *
     *  Запрос ввода сроки.
     *
     */

    public void strInput(String name) {
        System.out.printf("Введите %s\n", name);
    }

    /**
     *
     *  Вывод переданной строки.
     *
     */

    public void outputString(String str) {
        System.out.println(str);
    }

    /**
     *
     *  Вывод баланса.
     *
     */

    public void outputBalance(String name, float balance) {
        System.out.printf("Баланс игрока %s составляет %.2f", name, balance);
    }

    public void nameNotUnique() {
        System.out.println("Имя не уникально. Введите другое.");
    }
}

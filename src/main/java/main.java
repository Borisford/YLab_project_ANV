import bases.PlayerBase;
import bases.TransactionBase;
import exceptions.EqualNamesException;
import exceptions.InvalidInputDataException;
import exceptions.NotEnoughMoneyException;
import exceptions.WrongValidationException;
import input.ConsoleInput;
import input.Input;
import log.Log;
import log.Record;
import output.ConsoleOutput;
import output.Output;
import player.Player;
import playerPrats.Balance;
import transaction.Transaction;

public class main {
    private static boolean IS_ON = true;
    private static final Output output = new ConsoleOutput();
    private static final Input input = new ConsoleInput(output);
    private static final PlayerBase playerBase = new PlayerBase();
    private static final TransactionBase transactionBase = new TransactionBase();
    private static final Log log = new Log();

    public static void main(String[] args) {
        int var;
        while (IS_ON) {
            output.mainMenu();
            var = input.getVariants(4);
            if (var == 1) {
                registration();
            }
            if (var == 2) {
                logIn();
            }
            if (var == 3) {
                audit();
            }
            IS_ON = !(var == 4);

        }
    }

    private static void audit() {
        String name = input.getNamedString("имя по которому нужно предоставить аудит");
        output.outputString(log.getAuditString(name));
    }

    private static void registration() {
        String name = "";
        while (true) {
            name = input.getNamedString("имя");
            if (playerBase.checkNameInBase(name)) {
                output.nameNotUnique();
            } else if (!name.equals("")) {
                break;
            }
        }
        String password = input.getNamedString("пароль");
        try {
            playerBase.addPlayer(new Player(name, password));
        } catch (EqualNamesException e) {
            e.printStackTrace();
        }
    }

    private static void logIn() {
        String name = input.getNamedString("имя");
        if (playerBase.checkNameInBase(name)) {
            String password = input.getNamedString("пароль");
            Player player = playerBase.getPlayer(name);
            Balance balance = null;
            try {
                balance = player.getBalance(password);
            } catch (WrongValidationException e) {
                output.outputString("Пароль неверен.");
            }
            if (balance != null) {
                log.addRecord(Record.createLogIn(name));
                doOperation(balance, name);
            }
        } else {
            output.outputString("Игрока с именем " + name + " не существует");
        }
    }

    private static void doOperation(Balance balance, String name) {
        int var;
        boolean logged = true;
        while (logged) {
            output.operationMenu();
            var = input.getVariants(4);
            if (var == 1 || var == 2) {
                doDebitCredit(var, name, balance);
            }
            if (var == 3) {
                float bal = balance.getBalance();
                output.outputBalance(name, bal);
                log.addRecord(Record.createBalance(name, bal));
            }
            logged = !(var == 4);
        }
        log.addRecord(Record.createLogOut(name));
    }

    private static void doDebitCredit(int var, String name, Balance balance) {
        String id = input.getNamedString("идентификатор транзакции");
        int sum = input.getSum();
        if (transactionBase.checkIdInBase(id)) {
            output.outputString("Идентификатор транзакции не уникален.");
        } else {
            Transaction transaction = null;
            if (var == 1) {
                try {
                    balance.credit(sum);
                    transaction = Transaction.createCredit(name, sum);
                    log.addRecord(Record.createCredit(name, sum));
                } catch (InvalidInputDataException e) {
                    output.outputString("Невозможно положить на счёт столько.");
                }
            }
            if (var == 2) {
                try {
                    balance.debit(sum);
                    transaction = Transaction.createDebit(name, sum);
                    log.addRecord(Record.createDebit(name, sum));
                } catch (NotEnoughMoneyException e) {
                    output.outputString("На счету не хватает денег.");
                } catch (InvalidInputDataException e) {
                    output.outputString("Невозможно снять со счёта столько.");
                }
            }
            try {
                transactionBase.addTransaction(id, transaction);
            } catch (EqualNamesException e) {
                e.printStackTrace();
            }
        }
    }
}

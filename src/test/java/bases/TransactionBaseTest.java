package bases;

import exceptions.EqualNamesException;
import exceptions.InvalidInputDataException;
import org.testng.Assert;
import org.testng.annotations.Test;
import transaction.Transaction;

/**
 *
 *  Проверка базы транзакций.
 *
 */

public class TransactionBaseTest {

    /**
     *
     *  Проверка возможности добавит корректную иранзакцию.
     *
     */

    @Test
    public void test1() {
        TransactionBase transactionBase = new TransactionBase();
        boolean test = true;
        try {
            transactionBase.addTransaction("111", Transaction.createCredit("Boris", 10));
        } catch (EqualNamesException | InvalidInputDataException e) {
            e.printStackTrace();
            test = false;
        }
        Assert.assertTrue(test);
    }

    /**
     *
     *  Проверка наличия в базе добавленной ртанзакции.
     *
     */

    @Test
    public void test2() {
        TransactionBase transactionBase = new TransactionBase();
        try {
            transactionBase.addTransaction("111", Transaction.createCredit("Boris", 10));
        } catch (EqualNamesException | InvalidInputDataException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(transactionBase.checkIdInBase("111"));
    }

    /**
     *
     *  Проверка отсутствия в базе недобавленной транзакции.
     *
     */

    @Test
    public void test3() {
        TransactionBase transactionBase = new TransactionBase();
        try {
            transactionBase.addTransaction("111", Transaction.createCredit("Boris", 10));
        } catch (EqualNamesException | InvalidInputDataException e) {
            e.printStackTrace();
        }
        Assert.assertFalse(transactionBase.checkIdInBase("333"));
    }

    /**
     *
     *  Проверка невозможности добавить транзакцию с неуникальным ID.
     *
     */

    @Test
    public void test4() {
        TransactionBase transactionBase = new TransactionBase();
        boolean test = false;
        try {
            transactionBase.addTransaction("111", Transaction.createCredit("Boris", 10));
            transactionBase.addTransaction("111", Transaction.createCredit("Igor", 110));
        } catch (InvalidInputDataException e) {
            e.printStackTrace();
        } catch (EqualNamesException  e) {
            e.printStackTrace();
            test = true;
        }
        Assert.assertTrue(test);
    }
}

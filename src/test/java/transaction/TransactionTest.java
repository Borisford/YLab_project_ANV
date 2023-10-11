package transaction;

import exceptions.InvalidInputDataException;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 *  Првека класса для сохканения транзакций.
 *
 */

public class TransactionTest {

    /**
     *
     *  Проверка возможности создания кредитных транзакций с корректними данными.
     *
     */

    @Test
    public void test1() {
        boolean test = true;
        try {
            Transaction transaction = Transaction.createCredit("Boris", 10);
        } catch (InvalidInputDataException e) {
            e.printStackTrace();
            test = false;
        }
        Assert.assertTrue(test);
    }

    /**
     *
     *  Проверка возможности создания дебитовых транзакций с корректними данными.
     *
     */

    @Test
    public void test2() {
        boolean test = true;
        try {
            Transaction transaction = Transaction.createDebit("Boris", 10);
        } catch (InvalidInputDataException e) {
            e.printStackTrace();
            test = false;
        }
        Assert.assertTrue(test);
    }

    /**
     *
     *  Проверка невозможности создания кредитных транзакций с некорректними данными.
     *
     */

    @Test
    public void test3() {
        boolean test = false;
        try {
            Transaction transaction = Transaction.createCredit("Boris", -10);
        } catch (InvalidInputDataException e) {
            e.printStackTrace();
            test = true;
        }
        Assert.assertTrue(test);
    }

    /**
     *
     *  Проверка невозможности создания дебитовых транзакций с некорректними данными.
     *
     */

    @Test
    public void test4() {
        boolean test = false;
        try {
            Transaction transaction = Transaction.createDebit("Boris", -10);
        } catch (InvalidInputDataException e) {
            e.printStackTrace();
            test = true;
        }
        Assert.assertTrue(test);
    }

    /**
     *
     *  Проверка корректности вида у созданной транзакции.
     *
     */

    @Test
    public void test5() {
        Transaction transaction = null;
        try {
            transaction = Transaction.createCredit("Boris", 10);
        } catch (InvalidInputDataException e) {
            e.printStackTrace();
        }
        assert transaction != null;
        Assert.assertEquals(transaction.getSort(), SortOfTransaction.CREDIT);
    }

    /**
     *
     *  Проверка корректности вида у созданной транзакции.
     *
     */

    @Test
    public void test6() {
        Transaction transaction = null;
        try {
            transaction = Transaction.createDebit("Boris", 10);
        } catch (InvalidInputDataException e) {
            e.printStackTrace();
        }
        assert transaction != null;
        Assert.assertEquals(transaction.getSort(), SortOfTransaction.DEBIT);
    }

    /**
     *
     *  Проверка корректности имени у созданной транзакции.
     *
     */

    @Test
    public void test7() {
        Transaction transaction = null;
        try {
            transaction = Transaction.createCredit("Boris", 10);
        } catch (InvalidInputDataException e) {
            e.printStackTrace();
        }
        assert transaction != null;
        Assert.assertEquals(transaction.getName(), "Boris");
    }

    /**
     *
     *  Проверка корректности суммы у созданной транзакции.
     *
     */

    @Test
    public void test8() {
        Transaction transaction = null;
        try {
            transaction = Transaction.createCredit("Boris", 10);
        } catch (InvalidInputDataException e) {
            e.printStackTrace();
        }
        assert transaction != null;
        Assert.assertEquals(transaction.getQuantity(), 10);
    }

    /**
     *
     *  Проверка равенства созданных транзакций.
     *
     */

    @Test
    public void test9() {
        Transaction transaction1 = null;
        Transaction transaction2 = null;
        try {
            transaction1 = Transaction.createCredit("Boris", 10);
            transaction2 = Transaction.createCredit("Boris", 10);
        } catch (InvalidInputDataException e) {
            e.printStackTrace();
        }
        assert transaction1 != null;
        assert transaction2 != null;
        Assert.assertEquals(transaction1, transaction2);
    }
}

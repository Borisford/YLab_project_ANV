package playerParts;

import exceptions.InvalidInputDataException;
import exceptions.NotEnoughMoneyException;
import org.testng.Assert;
import org.testng.annotations.Test;
import playerPrats.Balance;

/**
 *
 *  Проверка баланса.
 *
 */

public class BalanceTest {

    /**
     *
     *  Проверка стартового баланса.
     *
     */

    @Test
    public void test1() {
        Balance balance = new Balance();
        Assert.assertEquals(balance.getBalance(), 0);
    }

    /**
     *
     *  Проверка кредитной операции.
     *
     */

    @Test
    public void test2() {
        Balance balance = new Balance();
        try {
            balance.credit(100);
        } catch (InvalidInputDataException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(balance.getBalance(), 100);
    }

    /**
     *
     *  Проверка невозможности списания болше чем есть у игрока.
     *
     */

    @Test
    public void test3() {
        Balance balance = new Balance();
        try {
            balance.credit(100);
        } catch (InvalidInputDataException e) {
            e.printStackTrace();
        }
        boolean except = false;
        try {
            balance.debit(150);
        } catch (NotEnoughMoneyException e) {
            e.printStackTrace();
            except = true;
        } catch (InvalidInputDataException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(except);
    }

    /**
     *
     *  Проверка корректности баланса после корректного списания.
     *
     */

    @Test
    public void test4() {
        Balance balance = new Balance();
        try {
            balance.credit(100);
        } catch (InvalidInputDataException e) {
            e.printStackTrace();
        }
        try {
            balance.debit(50);
        } catch (NotEnoughMoneyException | InvalidInputDataException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(balance.getBalance(), 50);
    }

    /**
     *
     *  Проверка невозможности начислить отрицательную сумму.
     *
     */

    @Test
    public void test5() {
        Balance balance = new Balance();
        boolean except = false;
        try {
            balance.credit(-100);
        } catch (InvalidInputDataException e) {
            e.printStackTrace();
            except = true;
        }
        Assert.assertTrue(except);
    }

    /**
     *
     *  Проверка невозможности списать отрицательную сумму.
     *
     */

    @Test
    public void test6() {
        Balance balance = new Balance();
        try {
            balance.credit(100);
        } catch (InvalidInputDataException e) {
            e.printStackTrace();
        }
        boolean except = false;
        try {
            balance.debit(-150);
        } catch (NotEnoughMoneyException e) {
            e.printStackTrace();
        } catch (InvalidInputDataException e) {
            e.printStackTrace();
            except = true;
        }
        Assert.assertTrue(except);
    }
}

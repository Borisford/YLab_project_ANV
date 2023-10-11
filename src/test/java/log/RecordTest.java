package log;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 *  Проверка записи.
 *
 */

public class RecordTest {

    /**
     *
     *  Проверка корректности создания кредитной транзакции.
     *
     */

    @Test
    public void test1() {
        Record record = Record.createCredit("Boris", 100);
        Assert.assertEquals(record.getName(), "Boris");
        Assert.assertEquals(record.getRecordType(), RecordType.CREDIT);
        Assert.assertEquals(record.getDeltaBalance(), 100);
    }

    /**
     *
     *  Проверка корректности создания дебитовой транзакции.
     *
     */

    @Test
    public void test2() {
        Record record = Record.createDebit("Boris", 100);
        Assert.assertEquals(record.getName(), "Boris");
        Assert.assertEquals(record.getRecordType(), RecordType.DEBIT);
        Assert.assertEquals(record.getDeltaBalance(), 100);
    }

    /**
     *
     *  Проверка корректности создания записи о запросе баланса.
     *
     */

    @Test
    public void test3() {
        Record record = Record.createBalance("Boris", 100);
        Assert.assertEquals(record.getName(), "Boris");
        Assert.assertEquals(record.getRecordType(), RecordType.BALANCE);
        Assert.assertEquals(record.getDeltaBalance(), 100);
    }

    /**
     *
     *  Проверка корректности создания записи о залогинивании.
     *
     */

    @Test
    public void test4() {
        Record record = Record.createLogIn("Boris");
        Assert.assertEquals(record.getName(), "Boris");
        Assert.assertEquals(record.getRecordType(), RecordType.LOG_IN);
        Assert.assertEquals(record.getDeltaBalance(), 0);
    }

    /**
     *
     *  Проверка корректности создания записи о разлогинивании.
     *
     */

    @Test
    public void test5() {
        Record record = Record.createLogOut("Boris");
        Assert.assertEquals(record.getName(), "Boris");
        Assert.assertEquals(record.getRecordType(), RecordType.LOG_OUT);
        Assert.assertEquals(record.getDeltaBalance(), 0);
    }
}

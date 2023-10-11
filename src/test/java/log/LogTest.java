package log;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 *  Проверка логов.
 *
 */

public class LogTest {

    /**
     *
     *  Проверка создания.
     *
     */

    @Test
    public void test1() {
        Log log = new Log();
        Assert.assertNotNull(log);
    }

    /**
     *
     *  Проверка чтения и записи.
     *
     */

    @Test
    public void test2() {
        Log log = new Log();
        Record record = Record.createCredit("Boris", 100);
        log.addRecord(record);
        Assert.assertEquals(record, log.getRecord(0));
    }
}

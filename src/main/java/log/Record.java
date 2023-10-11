package log;

import java.sql.Time;
import java.util.Objects;

/**
 *
 *  Класс записи о действиях игрока.
 *
 */

public class Record {
    private final String name;
    private final RecordType recordType;
    private final Time time;
    private final float deltaBalance;

    private Record(String name, RecordType recordType, float deltaBalance) {
        this.name = name;
        this.recordType = recordType;
        this.deltaBalance = deltaBalance;
        this.time = new Time(System.currentTimeMillis());
    }

    /**
     *
     *  Конструкторы для каждого возможног действия. Скорее всего переделаю в фабрику.
     *
     */

    public static Record createDebit(String name, float deltaBalance) {
        return new Record(name, RecordType.DEBIT, deltaBalance);
    }

    public static Record createCredit(String name, float deltaBalance) {
        return new Record(name, RecordType.CREDIT, deltaBalance);
    }

    public static Record createBalance(String name, float balance) {
        return new Record(name, RecordType.BALANCE, balance);
    }

    public static Record createLogIn(String name) {
        return new Record(name, RecordType.LOG_IN, 0);
    }

    public static Record createLogOut(String name) {
        return new Record(name, RecordType.LOG_OUT, 0);
    }

    @Override
    public String toString() {
        if (recordType == RecordType.CREDIT || recordType == RecordType.DEBIT || recordType == RecordType.BALANCE) {
            return  name + "; " +
                    recordType + "; " +
                    time + "; " +
                    String.format("%.2f", deltaBalance) + "; ";
        }
        if (recordType == RecordType.LOG_IN || recordType == RecordType.LOG_OUT) {
            return  name + "; " +
                    recordType + "; " +
                    time + "; ";
        }
        return "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return Float.compare(record.deltaBalance, deltaBalance) == 0 && name.equals(record.name) && recordType == record.recordType && time.equals(record.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, recordType, time, deltaBalance);
    }

    public String getName() {
        return name;
    }

    public RecordType getRecordType() {
        return recordType;
    }

    public float getDeltaBalance() {
        return deltaBalance;
    }
}

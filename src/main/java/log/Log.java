package log;

import java.util.HashMap;
import java.util.Map;

/**
 *
 *  Коллекция для сохранения логов действий.
 *
 */

public class Log {
    private long nextId;
    private final Map<Long, Record> base;

    public Log() {
        this.base = new HashMap<>();
        this.nextId = 0;
    }

    /**
     *
     *  Логи сохрняются под автоматически выделяемыми id.
     *
     */

    public void addRecord(Record record) {
        this.base.put(nextId, record);
        nextId++;
    }

    /**
     *
     *  Получени записи по id.
     *
     */

    public Record getRecord(long id) {
        return base.get(id);
    }

    /**
     *
     *  Выборка всех действий игрока по имени в виде коллекции.
     *
     */

    public Map<Long, Record> getAudit(String name) {
        Map<Long, Record> res = new HashMap<>();
        Record tmp;
        for (long i = 0; i < nextId; i++) {
            tmp = base.get(i);
            if (tmp.getName().equals(name)) {
                res.put(i, tmp);
            }
        }
        return res;
    }

    /**
     *
     *  Выборка всех действий игрока по имени в виде строки.
     *
     */

    public String getAuditString(String name) {
        Map<Long, Record> map = getAudit(name);
        StringBuilder res = new StringBuilder();
        for (long key: map.keySet()) {
            res.append(map.get(key)).append("\n");
        }
        if (res.length() != 0) {
            return res.substring(0, res.length() - 1);
        }
        return "Операций нет.";
    }
}

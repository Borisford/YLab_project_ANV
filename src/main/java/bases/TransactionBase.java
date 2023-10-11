package bases;

import exceptions.EqualNamesException;
import transaction.Transaction;

import java.util.HashMap;
import java.util.Map;

/**
 *
 *  Коллекция для хранения транзакций.
 *
 */

public class TransactionBase {
    private Map<String, Transaction> base;

    public TransactionBase() {
        this.base = new HashMap<>();
    }

    /**
     *
     *  Поверка наличия транзакции в базе по id.
     *
     */

    public boolean checkIdInBase(String id) {
        return base.containsKey(id);
    }

    /**
     *
     *  Добавление транзакции. В случае неуникальности транзакции выбрасывается исключение.
     *
     */

    public void addTransaction(String id, Transaction transaction) throws EqualNamesException {
        if (!checkIdInBase(id)) {
            base.put(id, transaction);
        } else  {
            throw new EqualNamesException("Id транзакции не уникален.");
        }
    }
}

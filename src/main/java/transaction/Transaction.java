package transaction;

import exceptions.InvalidInputDataException;

import java.util.Objects;

/**
 *
 *  Класс транзакций. Содержит имя игрока, совершившего транзакцию, вид транзакции и сумму транзакции.
 *
 */

public class Transaction {
    private final String Name;
    private final SortOfTransaction Sort;
    private final float Quantity;

    private Transaction(String name, SortOfTransaction sort, float quantity) {
        Name = name;
        Sort = sort;
        Quantity = quantity;
    }

    /**
     *
     *  Функиции создания разного вида транзакций.
     *
     */

    public static Transaction createDebit(String name, float quantity) throws InvalidInputDataException {
        if (quantity >= 0) {
            return new Transaction(name, SortOfTransaction.DEBIT, quantity);
        } else {
            throw new InvalidInputDataException("Отрицательная транзакция");
        }
    }

    public static Transaction createCredit(String name, float quantity) throws InvalidInputDataException {
        if (quantity >= 0) {
            return new Transaction(name, SortOfTransaction.CREDIT, quantity);
        } else {
            throw new InvalidInputDataException("Отрицательная транзакция");
        }
    }

    public String getName() {
        return Name;
    }

    public SortOfTransaction getSort() {
        return Sort;
    }

    public float getQuantity() {
        return Quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Float.compare(that.Quantity, Quantity) == 0 && Name.equals(that.Name) && Sort == that.Sort;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name, Sort, Quantity);
    }
}

package player;

import exceptions.WrongValidationException;
import playerPrats.Balance;

import java.util.Objects;

/**
 *
 *  Класс игрока. Содержит имя, парол и баланс.
 *
 */

public class Player {
    private final String name;
    private final String password;
    private final Balance balance;

    public Player(String name, String password) {
        this.name = name;
        this.password = password;
        this.balance = new Balance();
    }

    public String getName() {
        return name;
    }

    /**
     *
     *  Баланс возвращается при проверке пароля. После проверки пароля возможны любые действия с балансом.
     *
     */

    public Balance getBalance(String password) throws WrongValidationException {
        validatePlayer(password);
        return balance;
    }

    public Balance getBalance(String name, String password) throws WrongValidationException {
        validatePlayer(name, password);
        return balance;
    }

    /**
     *
     *  Проверка пароля.
     *
     */

    protected void validatePlayer(String password) throws WrongValidationException {
        if (!this.password.equals(password)) {
            throw new WrongValidationException();
        }
    }

    private void validatePlayer(String name, String password) throws WrongValidationException {
        if (!this.name.equals(name) || !this.password.equals(password)) {
            throw new WrongValidationException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return name.equals(player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                balance +
                '}';
    }
}

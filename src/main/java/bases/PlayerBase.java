package bases;

import exceptions.EqualNamesException;
import player.Player;

import java.util.HashMap;
import java.util.Map;

/**
 *
 *  Коллекция для сохранения данных об игроках.
 *
 */

public class PlayerBase {
    private final Map<String, Player> base;

    public PlayerBase() {
        this.base = new HashMap<>();
    }

    /**
     *
     *  Добавление игрка в базу. В случае неуникальносьности игрока (совпадение имени) выбрасывается исключение.
     *
     */

    public void addPlayer(Player player) throws EqualNamesException {
        String name = player.getName();
        if (!checkNameInBase(name)) {
            base.put(name, player);
        } else {
            throw new EqualNamesException("В базе уже есть игрок с таким именем.");
        }
    }

    /**
     *
     *  Проверка наличия имени в базе.
     *
     */

    public boolean checkNameInBase(String name) {
        return base.containsKey(name);
    }

    /**
     *
     *  Получение игрока из базы по имени. В случае отсутствия возвращается null.
     *
     */

    public Player getPlayer(String name) {
        return base.get(name);
    }
}

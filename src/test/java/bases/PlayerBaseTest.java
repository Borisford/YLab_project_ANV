package bases;

import exceptions.EqualNamesException;
import org.testng.Assert;
import org.testng.annotations.Test;
import player.Player;

/**
 *
 *  Тесты коллекции игроков.
 *
 */

public class PlayerBaseTest {

    /**
     *
     *  Проверка возможности добавления игрока с корректными данными.
     *
     */

    @Test
    public void test1() {
        PlayerBase playerBase = new PlayerBase();
        Player vova = new Player("Vova", "123456");
        try {
            playerBase.addPlayer(vova);
        } catch (EqualNamesException e) {
            e.printStackTrace();
        }
        Player player = playerBase.getPlayer("Vova");
        Assert.assertEquals(player, vova);
    }

    /**
     *
     *  Проверка невозможности добавить игрока с неуникальным именем.
     *
     */

    @Test
    public void test2() {
        PlayerBase playerBase = new PlayerBase();
        Player vova1 = new Player("Vova", "123456");
        Player vova2 = new Player("Vova", "111111");
        boolean test = false;
        try {
            playerBase.addPlayer(vova1);
            playerBase.addPlayer(vova2);
        } catch (EqualNamesException e) {
            e.printStackTrace();
            test = true;
        }
        Assert.assertTrue(test);
    }

    /**
     *
     * Проверка запроса отсутствующего игрока.
     *
     */

    @Test
    public void test3() {
        PlayerBase playerBase = new PlayerBase();
        Player player = playerBase.getPlayer("Vova");
        Assert.assertNull(player);
    }

    /**
     *
     *  Проверка наличия в базе добаленного игрока.
     *
     */

    @Test
    public void test4() {
        PlayerBase playerBase = new PlayerBase();
        Player vova = new Player("Vova", "123456");
        try {
            playerBase.addPlayer(vova);
        } catch (EqualNamesException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(playerBase.checkNameInBase("Vova"));
    }

    /**
     *
     *  Проверка отсутствия в базе недобавленного игрока.
     *
     */

    @Test
    public void test5() {
        PlayerBase playerBase = new PlayerBase();
        Assert.assertFalse(playerBase.checkNameInBase("Vova"));
    }
}

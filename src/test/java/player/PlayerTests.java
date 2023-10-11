package player;

import exceptions.WrongValidationException;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 *  Проверка игрока.
 *
 */

public class PlayerTests {

    /**
     *
     *  Проверка стартового баланса.
     *
     */

    @Test
    public void test1() {
        Player player = new Player("Vova", "vist");
        try {
            Assert.assertEquals(player.getBalance("vist").getBalance(), 0);
        } catch (WrongValidationException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     *  Проверка корректности сохранения имени.
     *
     */

    @Test
    public void test2() {
        Player player = new Player("Boris", "serp");
        Assert.assertEquals(player.getName(), "Boris");
    }

    /**
     *
     *  Проверка равенства.
     *
     */

    @Test
    public void test3() {
        Player player1 = new Player("Ivan", "12345");
        Player player2 = new Player("Ivan", "12345");
        Assert.assertEquals(player1, player2);
    }
}

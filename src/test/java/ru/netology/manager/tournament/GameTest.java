package ru.netology.manager.tournament;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {
    Game game = new Game();
    Player player1 = new Player(1, "Josh", 17);
    Player player2 = new Player(2, "Mary", 15);
    Player player3 = new Player(3, "Jane", 17);

    @Test
    public void registerTest() {
        game.register(player1);
        game.register(player2);
        game.register(player3);

        assertEquals(3, game.registered.size());
    }

    @Test
    public void firstNotRegisteredTest() {
        game.register(player1);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Jannet", "Josh");
        });
    }

    @Test
    public void secondNotRegisteredTest() {
        game.register(player1);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Josh", "Jannet");
        });
    }

    @Test
    public void roundFirstWinTest() {
        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Josh", "Mary");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void roundSecondWinTest() {
        game.register(player2);
        game.register(player3);

        int expected = 2;
        int actual = game.round("Mary", "Jane");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void roundBothWinTest() {
        game.register(player1);
        game.register(player3);

        int expected = 0;
        int actual = game.round("Josh", "Jane");

        Assertions.assertEquals(expected, actual);
    }
}

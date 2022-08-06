import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    Game game = new Game();

    Player player1 = new Player(1, "A", 5);
    Player player2 = new Player(2, "B", 6);
    Player player3 = new Player(2, "C", 5);

    @Test
    public void shouldShowExceptionWhenFirstPlayerNotRegistered() {
        game.register(player1);

        assertThrows(NotRegisteredException.class, ()-> {
            game.round("A", "B");
        });
    }

    @Test
    public void shouldShowExceptionWhenSecondPlayerNotRegistered() {
        game.register(player2);

        assertThrows(NotRegisteredException.class, ()-> {
            game.round("A", "B");
        });
    }

    @Test
    public void shouldDefineFirstPlayerVictory() {
        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("B", "A");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldDefineSecondPlayerVictory() {
        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round("A", "B");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldDefineDraw() {
        game.register(player1);
        game.register(player3);

        int expected = 0;
        int actual = game.round("A", "C");

        assertEquals(expected, actual);
    }
}

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test

    public void testIfFirstPlayerWins() {
        Game game = new Game();
        Player Maria = new Player(1, "Maria", 75);
        Player Kate = new Player(2, "Kate", 90);

        game.register(Maria);
        game.register(Kate);

        int actual = game.round("Kate", "Maria");
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void testIfSecondPlayerWins() {
        Game game = new Game();
        Player Maria = new Player(1, "Maria", 75);
        Player Kate = new Player(2, "Kate", 90);


        game.register(Maria);
        game.register(Kate);

        int actual = game.round("Maria", "Kate");
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void testDrawWinsPlayer() {
        Game game = new Game();
        Player Maria = new Player(1, "Maria", 90);
        Player Kate = new Player(2, "Kate", 90);

        game.register(Maria);
        game.register(Kate);

        int actual = game.round("Maria", "Kate");
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ifFirstPlayerNotRegistered() {
        Game game = new Game();
        Player Maria = new Player(1, "Maria", 75);
        Player Kate = new Player(2, "Kate", 90);


        game.register(Maria);
        game.register(Kate);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Max", "Kate"));
    }

    @Test
    public void ifSecondPlayerNotRegistered() {
        Game game = new Game();
        Player Maria = new Player(1, "Maria", 75);
        Player Kate = new Player(2, "Kate", 90);


        game.register(Maria);
        game.register(Kate);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Maria", "Mark"));
    }

    @Test
    public void ifBothPlayersNotRegistered() {
        Game game = new Game();
        Player Maria = new Player(1, "Maria", 75);
        Player Kate = new Player(2, "Kate", 90);


        game.register(Maria);
        game.register(Kate);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Max", "Mark"));
    }
}
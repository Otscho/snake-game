package ch.winel.zli.game.snake_game.Tests;

import ch.winel.zli.game.snake_game.Snake;
import ch.winel.zli.game.snake_game.util.Coord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

public class SnakeTest {

    private Snake snake;;
    private List<Coord> snakePositions;


    @Test
    public void testGetHeadPosition() {
        Snake snake = new Snake();
        Coord head = snake.getHeadPosition();
        Assertions.assertEquals(new Coord(1, 1), head);
    }
}
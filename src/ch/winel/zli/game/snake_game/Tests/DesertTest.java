package ch.winel.zli.game.snake_game.Tests;

import ch.winel.zli.game.snake_game.Desert;
import ch.winel.zli.game.snake_game.util.Coord;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DesertTest {

    @Test
    public void testGetRandomPosition() {
        Desert desert = new Desert();
        Coord position = desert.getRandomPosition();
        Assertions.assertTrue(position.x >= 0 && position.x < 16);
        Assertions.assertTrue(position.y >= 0 && position.y < 16);
    }
}

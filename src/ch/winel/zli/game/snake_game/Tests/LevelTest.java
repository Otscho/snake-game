package ch.winel.zli.game.snake_game.Tests;

import ch.winel.zli.game.snake_game.Desert;
import ch.winel.zli.game.snake_game.Level;
import ch.winel.zli.game.snake_game.Obstacles;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class LevelTest {


    @Test
    public void testGetLevelVelocity() {
        Level level = new Level();
        Assertions.assertEquals(400, level.getLevelVelocity());
    }

    @Test
    public void testGetSnake() {
        Level level = new Level();
        var snake = level.getSnake();
        Assertions.assertNotNull(snake);
    }

    @Test

    public void testGetObstacles() {
        Level level = new Level();
        Obstacles obstacles = level.getObstacles();
        Assertions.assertNotNull(obstacles);
    }

    @Test
    public void testGetDesert() {
        Level level = new Level();
        Desert desert = level.getDesert();
        Assertions.assertNotNull(desert);
    }

    @Test
    public void testSetLevelVelocity() {
        Level level = new Level();
        level.setLevelVelocity(500);
        Assertions.assertEquals(500, level.getLevelVelocity());
    }
}

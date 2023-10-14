package ch.winel.zli.game.snake_game.Tests;

import ch.winel.zli.game.snake_game.Food;
import ch.winel.zli.game.snake_game.util.Coord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class FoodTest {
    
    Food food;
    
    @Test
    public void testConstructor() {
        food = new Food();
        Food food = new Food();
        Assertions.assertNotNull(food.foodPositions);
        Assertions.assertEquals(1, food.foodPositions.size());
    }

    @Test
    public void testAddFood() {
        Food food = new Food();
        List<Coord> snakePositions = new ArrayList<>();
        List<Coord> obstaclesPositions = new ArrayList<>();
        snakePositions.add(new Coord(1, 1));
        food.addFood(snakePositions, obstaclesPositions);
        Assertions.assertEquals(2, food.foodPositions.size());
    }
}

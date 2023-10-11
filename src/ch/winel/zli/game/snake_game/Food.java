package ch.winel.zli.game.snake_game;

import ch.winel.zli.game.snake_game.util.Coord;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Food {
    private final List<Coord> foodPositions;
    private Random rand = new Random();

    public Food() {
        foodPositions = new ArrayList<>();
    }
        public void draw(Graphics2D g, int dx, int dy) {
            // Generate a random position for the food item
            int x = rand.nextInt(dx -1);
            int y = rand.nextInt(dy -1);
            foodPositions.add(new Coord(x, y));
            g.setColor(Color.green);
            g.fillOval(
                    foodPositions.get(0).x * dx,
                    foodPositions.get(0).y * dy,
                    dx,
                    dy
            );
    }
    public void replaceFood() {
            foodPositions.remove(0);
        }

    public List<Coord> getFoodPositions() {
        return foodPositions;
    }

    public boolean intersectsWith(Coord snakePos) {
        for (Coord foodPosition : foodPositions) {
            if (foodPosition.equals(snakePos)) {
                return true;
            }
        }
        return false;
    }
}

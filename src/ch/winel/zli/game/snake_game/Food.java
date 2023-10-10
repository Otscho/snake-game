package ch.winel.zli.game.snake_game;

import ch.winel.zli.game.snake_game.util.Coord;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Food {
    private final List<Coord> foodPos;
    private Random rand = new Random();

    public Food() {
        foodPos = new ArrayList<>();
    }
        public void draw(Graphics2D g, int dx, int dy) {
            // Generate a random position for the food item
            int x = rand.nextInt(dx);
            int y = rand.nextInt(dy);
            foodPos.add(new Coord(x, y));
            g.setColor(Color.green);
            g.fillOval(
                    foodPos.get(0).x * dx,
                    foodPos.get(0).y * dy,
                    dx,
                    dy
            );
    }
    public void removeFood() {
            foodPos.remove(0);
        }

    public Coord getFoodPosition() {
            return foodPos.get(0);
    }
}

package ch.winel.zli.game.snake_game;

import ch.winel.zli.game.snake_game.util.Coord;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Food {
    private final List<Coord> foodPositions;

    public Food(Coord random) {
        foodPositions = new ArrayList<>();
        foodPositions.add(random);
    }

    public void draw(Graphics2D g, int dx, int dy) {
        for (Coord pos : foodPositions) {
            g.setColor(Color.GREEN);
            g.fillOval(
                    pos.x * dx,
                    pos.y * dy,
                    dx,
                    dy
            );
        }
    }

    public void addFood(Coord randomPosition) {
        foodPositions.add(randomPosition);
    }

    public List<Coord> getFoodPositions() {
        return foodPositions;
    }

    public void removeFood(List<Coord> snakePositions) {
        foodPositions.removeIf(snakePositions::contains);
    }
}
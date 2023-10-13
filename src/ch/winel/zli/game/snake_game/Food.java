package ch.winel.zli.game.snake_game;

import ch.winel.zli.game.snake_game.util.Coord;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Food {
    public final List<Coord> foodPositions;
    private final Desert desert = new Desert();
    private final Obstacles obstacles = new Obstacles();

    public Food() {
        foodPositions = new ArrayList<>();
        List<Coord> snakeStartPos = new ArrayList<>();
        snakeStartPos.add(new Coord(1, 1));
        addFood(snakeStartPos);
    }

    /**
     * @param g  Graphics2D
     * @param dx pixel size of x Coordinate
     * @param dy pixel size of y Coordinate
     */
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

    // Add food and checks if food intersects with snake ore obstacle before add
    public void addFood(List<Coord> snakePositions) {
        Coord randomPos;
        List<Coord> obstaclesPosition = obstacles.getObstaclePositions();
        randomPos = desert.getRandomPosition();
        while (snakePositions.contains(randomPos) || obstaclesPosition.contains(randomPos)) {
            randomPos = desert.getRandomPosition();
        }
        foodPositions.add(randomPos);
    }

    public List<Coord> getFoodPositions() {
        return foodPositions;
    }

    public void removeFood(List<Coord> snakePositions) {
        foodPositions.removeIf(snakePositions::contains);
    }
}
package ch.winel.zli.game.snake_game;

import ch.winel.zli.game.snake_game.util.Coord;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Obstacles {
    private final List<Coord> obstaclesPositions;
    private final Desert desert = new Desert();
    private Food food;
    public Obstacles(List<Coord> snakePositions) {
        obstaclesPositions = new ArrayList<>();
        addObstacle(snakePositions);
    }

    public void draw(Graphics2D g, int dx, int dy) {
        for (Coord obstaclesPosition : obstaclesPositions) {
            g.setColor(Color.RED);
            g.fillRect(
                    obstaclesPosition.x * dx,
                    obstaclesPosition.y * dy,
                    dx,
                    dy
            );
        }
    }

    // Add obstacle and checks if obstacle intersects with snake ore food before add
    public void addObstacle(List<Coord> snakePositions) {
        Coord randomPos;
        List<Coord> foodPosition = food.getFoodPositions();
        randomPos = desert.getRandomPosition();
        while (snakePositions.contains(randomPos) || foodPosition.contains(randomPos)) {
            randomPos = desert.getRandomPosition();
        }
        obstaclesPositions.add(randomPos);
    }

    public List<Coord> getObstaclePositions() {
        return obstaclesPositions;
    }

    public void removeObstacle(List<Coord> snakePositions) {
        obstaclesPositions.removeIf(snakePositions::contains);
    }
}

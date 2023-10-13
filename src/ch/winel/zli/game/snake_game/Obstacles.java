package ch.winel.zli.game.snake_game;

import ch.winel.zli.game.snake_game.util.Coord;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Obstacles {
    private final List<Coord> obstaclesPositions;
    private final Desert desert = new Desert();

    public Obstacles() {
        obstaclesPositions = new ArrayList<>();
        List<Coord> snakeStartPos = new ArrayList<>();
        snakeStartPos.add(new Coord(1, 1));
        addObstacle(snakeStartPos);
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
        randomPos = desert.getRandomPosition();
        while (snakePositions.contains(randomPos)) {
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

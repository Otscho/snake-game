package ch.winel.zli.game.snake_game;

import ch.winel.zli.game.snake_game.util.Coord;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Obstacles {
    private final List<Coord> obstaclesPositions;

    public Obstacles(Coord random ) {
        obstaclesPositions = new ArrayList<>();
        obstaclesPositions.add(random);
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

    public void addObstacle(Coord randomPosition) {
        obstaclesPositions.add(randomPosition);
    }

    public List<Coord> getObstaclePositions() {
        return obstaclesPositions;
    }

    public void removeObstacle(List<Coord> snakePositions) {
        obstaclesPositions.removeIf(snakePositions::contains);
    }
}

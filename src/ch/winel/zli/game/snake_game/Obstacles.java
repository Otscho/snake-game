package ch.winel.zli.game.snake_game;

import ch.winel.zli.game.snake_game.util.Coord;

import java.awt.*;
import java.util.List;

public class Obstacles {

    public Obstacles() {
    }

    public void draw(Graphics2D g, int dx, int dy, List<Coord> obstaclesPositions) {
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
}

package ch.winel.zli.game.snake_game;

import ch.winel.zli.game.snake_game.util.Coord;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Obstacles {
    private final List<Coord> obstaclesPos;
    private Random rand = new Random();

    public Obstacles() {
        obstaclesPos = new ArrayList<>();
    }
    public void draw(Graphics2D g, int dx, int dy) {
        // Generate a random position for the food item
        int x = rand.nextInt(dx -1);
        int y = rand.nextInt(dy -1);
        obstaclesPos.add(new Coord(x, y));
        g.setColor(Color.RED);
        g.fillRect(
                obstaclesPos.get(0).x * dx,
                obstaclesPos.get(0).y * dy,
                dx,
                dy
        );
    }

    public Coord getObstaclePosition() {
        return obstaclesPos.get(0);
    }
}

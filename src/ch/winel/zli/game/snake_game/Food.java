package ch.winel.zli.game.snake_game;

import ch.winel.zli.game.snake_game.util.Coord;

import java.awt.*;
import java.util.List;

public class Food {

    public Food() {
    }

    /**
     * @param g  Graphics2D
     * @param dx pixel size of x Coordinate
     * @param dy pixel size of y Coordinate
     */
    public void draw(Graphics2D g, int dx, int dy, List<Coord> foodPositions) {
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

}
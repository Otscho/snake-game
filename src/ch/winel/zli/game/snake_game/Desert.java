package ch.winel.zli.game.snake_game;

import ch.winel.zli.game.snake_game.util.Coord;
import ch.winel.zli.game.snake_game.util.MoveDirection;

import javax.swing.JPanel;
import java.awt.*;
import java.util.Random;

public class Desert {
    public int width;
    public int height;

    private  final int xSteps;
    private final int ySteps;

    private final Random rand = new Random();

    public Desert() {
        width = 16;
        height = 16;
        xSteps = width;
        ySteps = height;
    }
    public void draw(JPanel panel, Graphics2D g){
        g.setColor(Color.BLACK);
        g.fillRect(0,0, panel.getWidth(), panel.getHeight());
    }


    /**
     * @param position Position of the head of the snake
     * @param direction Direction that the snake moves
     * @return Returns the next position of the snake
     */
    public Coord getNextPosition(Coord position, MoveDirection direction){
        int x = position.x;
        int y = position.y;
        switch (direction) {
            case up: y--; break;
            case down: y++; break;
            case right: x++; break;
            case left: x--; break;
        }
        if (x >= xSteps) { x = 0; }
        if (y >= ySteps) { y = 0; }
        if (x < 0) { x = xSteps -1; }
        if (y < 0) { y = ySteps -1; }
        return new Coord(x, y);
    }

    /**
     * Get a random positions and returns it
     */
    public Coord getRandomPosition(){
        int x = rand.nextInt(xSteps -1);
        int y = rand.nextInt(ySteps -1);
        return new Coord(x, y);
    }
}

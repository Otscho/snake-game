package ch.winel.zli.game.snake_game;

import ch.winel.zli.game.snake_game.util.Coord;
import ch.winel.zli.game.snake_game.util.MoveDirection;

import javax.swing.JPanel;
import java.awt.*;

public class Desert {
    public int width;
    public int height;

    public Desert() {
        width = 16;
        height = 16;
    }
    public void draw(JPanel panel, Graphics2D g){
        g.setColor(Color.BLACK);
        g.fillRect(0,0, panel.getWidth(), panel.getHeight());
    }

    public Coord getNextPosition(Coord position, MoveDirection direction){
        int x = position.x;
        int y = position.y;
        switch (direction) {
            case up: y--; break;
            case down: y++; break;
            case right: x--; break;
            case left: x++; break;
        }
//        if (x >= xSteps) { x = 0; }
//        if (y >= ySteps) { y = 0; }
//        if (x < 0) { x = xSteps -1; }
//        if (y < 0) { y = ySteps -1; }
        return new Coord(x, y);
    }
}

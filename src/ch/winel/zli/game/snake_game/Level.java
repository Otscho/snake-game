package ch.winel.zli.game.snake_game;

import javax.swing.JPanel;
import java.awt.Graphics2D;

public class Level {
    private Desert desert;
    private Snake snake;

    public Level() {
        desert = new Desert();
        snake = new Snake();
    }

    public void draw(JPanel panel, Graphics2D g){
        int dx = panel.getWidth() / this.desert.width;
        int dy = panel.getHeight() / this.desert.height;
//        int offsetx = panel.getWidth() % dx;
//        int offsety = panel.getHeight() % dy;
        desert.draw(panel, g);
        snake.draw(g, dx, dy);
    }

    public long getLevelVelocity() {
        return 1000;
    }
    Snake getSnake(){
        return snake;
    }

    public Desert getDesert() {
        return desert;
    }
}

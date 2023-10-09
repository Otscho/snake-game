package ch.winel.zli.game.snake_game;

import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.security.PrivateKey;

public class Level {

    private final Desert desert = new Desert();
    private final Snake snake = new Snake();

    public void draw(JPanel panel, Graphics2D g){
        int dx = panel.getWidth() / this.desert.width;
        int dy = panel.getHeight() / this.desert.height;
        desert.draw(panel, g);
        int offsetx = panel.getWidth() % dx;
        int offsety = panel.getHeight() % dy;
        desert.draw(panel, g);
        snake.drawHead(g, dx, dy, dx, dx);
    }

    public long getLevelVelocity() {
        return 1000;
    }

}

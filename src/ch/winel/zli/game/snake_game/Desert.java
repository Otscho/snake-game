package ch.winel.zli.game.snake_game;

import javax.swing.JPanel;
import java.awt.*;

public class Desert {
    public final int width;
    public final int height;

    public Desert() {
        width = 25;
        height = 25;
    }
    public void draw(JPanel panel, Graphics2D g2d){
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0,0, panel.getWidth(), panel.getHeight());
    }
}

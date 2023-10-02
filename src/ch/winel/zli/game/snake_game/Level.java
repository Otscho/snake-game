package ch.winel.zli.game.snake_game;

import javax.swing.JPanel;
import java.awt.Graphics2D;
public class Level {

    private final Desert desert = new Desert();

    public void draw(JPanel panel, Graphics2D g){
        int squareWidth = panel.getWidth() / this.desert.width;
        int squareHeight = panel.getHeight() / this.desert.height;
        int offsetX = panel.getWidth() % squareWidth;
        int offsetY = panel.getHeight() % squareHeight;
        desert.draw(panel, g);
    }

}

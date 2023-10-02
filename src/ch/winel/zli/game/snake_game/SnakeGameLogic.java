package ch.winel.zli.game.snake_game;

import javax.swing.JPanel;
import java.awt.*;

public class SnakeGameLogic {
    private SnakeGame game;
    private Level level = new Level();

    public SnakeGameLogic(SnakeGame game){
        this.game = game;
    }
    public void draw(JPanel panel, Graphics2D g){
        level.draw(panel, g);
    }
}

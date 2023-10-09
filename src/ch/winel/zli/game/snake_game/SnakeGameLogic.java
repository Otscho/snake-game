package ch.winel.zli.game.snake_game;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class SnakeGameLogic {
    private SnakeGame game;
    private Level level = new Level();
    private Timer timer;

    public SnakeGameLogic(SnakeGame game) {
        this.game = game;
    }

    public void draw(JPanel panel, Graphics2D g) {
        level.draw(panel, g);
    }

    private void initAfterLevelChanged() {
        // Start paused

        // We need a periodical tick for this level
        if (timer != null) {
            timer.cancel();
        }
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                processTick();
            }
        }, 100, level.getLevelVelocity());

        // force redraw
    }

    private void processTick() {
        // if game over ore paused don't do anything
        if (game.isPauseGame() || game.isGameOver()){
            return;
        }
    }

}

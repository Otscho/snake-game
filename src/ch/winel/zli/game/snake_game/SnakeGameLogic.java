package ch.winel.zli.game.snake_game;

import ch.winel.zli.game.snake_game.util.Coord;
import ch.winel.zli.game.snake_game.util.MoveDirection;


import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class SnakeGameLogic {
    private SnakeGame game;

    private Level level;

    private Timer timer;

    public SnakeGameLogic(SnakeGame game) {
        this.game = game;
        this.level = new Level();
        initAfterLevelChanged();
    }

    public void draw(JPanel panel, Graphics2D g) {
        level.draw(panel, g);
    }

    void initAfterLevelChanged() {

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

    public void processTick() {
        // if game over ore paused don't do anything
        if (game.isPauseGame() || game.isGameOver()) {
            return;
        }
        Desert desert = level.getDesert();
        Snake snake = level.getSnake();
        Coord nextPosition = desert.getNextPosition(snake.getHeadPosition(), snake.getDirection());
        snake.movePosition(nextPosition);

        Food food = level.getFood();
        Coord foodPosition = food.getFoodPosition();
        if (foodPosition.equals(nextPosition)) {
            level.replaceFood();
        }
        game.gameNeedsRedraw();
    }

    public void changeDir(MoveDirection direction) {
        level.changeDir(direction);
    }

    public void cancelTimer() {
        timer.cancel();
    }
}

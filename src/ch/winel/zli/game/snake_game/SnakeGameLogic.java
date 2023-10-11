package ch.winel.zli.game.snake_game;

import ch.winel.zli.game.snake_game.util.Coord;
import ch.winel.zli.game.snake_game.util.MoveDirection;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class SnakeGameLogic {
    private SnakeGame game;

    private Level level;

    private Timer timer;
    private int points;
    private int levelHeight;

    public SnakeGameLogic(SnakeGame game) {
        this.game = game;
        this.level = new Level();
        this.points = 0;
        this.levelHeight = 1;
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
    }

    public void processTick() {
        // if game over ore paused don't do anything
        if (game.isPauseGame() || game.isGameOver()) {
            return;
        }
        Desert desert = level.getDesert();
        Snake snake = level.getSnake();
        Food food = level.getFood();

        Obstacles obstacles = level.getObstacles();

        Coord nextPosition = desert.getNextPosition(snake.getHeadPosition(), snake.getDirection());
        snake.movePosition(nextPosition);

        List<Coord> foodPositions = food.getFoodPositions();
        if (foodPositions.contains(nextPosition)) {
            level.replaceFood();
            snake.eat();
            points++;
        }

        // Checks if Snake has self collision
        if (snake.hasSelfCollision()){
            game.setGameOver();
        }

        // Checks if Snake collide with obstacle
        Coord obstaclesPosition = obstacles.getObstaclePosition();
        if (nextPosition.equals(obstaclesPosition)){
            game.setGameOver();
        }

        // Redraw the game
        game.gameNeedsRedraw();
    }

    public void changeDir(MoveDirection direction) {
        level.changeDir(direction);
    }

    public void cancelTimer() {
        timer.cancel();
    }

    public int getLevelHeight() {
        return this.levelHeight;
    }

    public int getPoints() {
        return this.points;
    }
}

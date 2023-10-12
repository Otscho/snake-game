package ch.winel.zli.game.snake_game;

import ch.winel.zli.game.snake_game.util.Coord;
import ch.winel.zli.game.snake_game.util.MoveDirection;


import javax.swing.*;
import java.awt.*;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class SnakeGameLogic {
    private final SnakeGame game;

    private final Level level = new Level();

    private Timer timer;
    private int points;
    private final int levelHeight;


    public SnakeGameLogic(SnakeGame game) {
        this.game = game;
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
        List<Coord> obstaclesPositions = obstacles.getObstaclePositions();

        // Tells the snake tod eat and adds Points
        if (foodPositions.contains(nextPosition)) {
            snake.eat();
            points++;
            level.replaceFood();
        }

//        // Replace food if snake ore obstacle owns position
//        for (Coord foodPosition : foodPositions) {
//            if (snakePositions.contains(foodPosition) || obstaclesPositions.contains(foodPosition)) {
//                food.removeFood(snake.getSnakePositions());
//                level.replaceFood();
//            }
//        }

        // Checks if Snake has self collision
        if (snake.hasSelfCollision()){
            game.setGameOver();
        }

        // Checks if Snake collide with obstacle
        if (obstaclesPositions.contains(nextPosition)){
            game.setGameOver();
        }

//        // Replace obstacle if snake ore food owns position
//        for (Coord obstaclePosition : obstaclesPositions) {
//            if (snakePositions.contains(obstaclePosition) || foodPositions.contains(obstaclePosition)) {
//                obstacles.removeObstacle(snake.getSnakePositions());
//                level.replaceObstacle();
//            }
//        }
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

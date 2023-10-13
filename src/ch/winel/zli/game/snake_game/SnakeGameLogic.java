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
    private Level level = new Level();
    private Timer timer;
    private int points;
    private int levelHeight;
    private LevelFactory levelFactory = new LevelFactory();

    // constructor
    public SnakeGameLogic(SnakeGame game) {
        this.game = game;
        this.points = 0;
        this.levelHeight = 1;
        initAfterLevelChanged();
    }

    // draw the level
    public void draw(JPanel panel, Graphics2D g) {
        level.draw(panel, g);
    }

    // process a tick of the game
    void processTick() {
        // if game over or paused, don't do anything
        if (game.isPauseGame() || game.isGameOver()) {
            return;
        }

        // get the Desert, Snake, Food, and Obstacles objects
        Desert desert = level.getDesert();
        Snake snake = level.getSnake();
        Food food = level.getFood();
        Obstacles obstacles = level.getObstacles();

        // get the next position of the snake based on its current position and direction
        Coord nextPosition = desert.getNextPosition(snake.getHeadPosition(), snake.getDirection());
        snake.movePosition(nextPosition);

        // check if the snake has eaten the food
        List<Coord> foodPositions = food.getFoodPositions();
        if (foodPositions.contains(nextPosition)) {
            snake.eat();
            points++;
            level.replaceFood();
        }

        // check if the snake has collided with an obstacle
        List<Coord> obstaclePositions = obstacles.getObstaclePositions();
        if (obstaclePositions.contains(nextPosition)) {
            game.setGameOver();
        }

        // check if the snake has collided with its own body
        if (snake.hasSelfCollision()) {
            game.setGameOver();
        }

        // increase the level if the number of points is a multiple of 10
        if (snake.eat) {
            if (points % 10 == 0 && points != 0) {
                level = levelFactory.createLevel();
                levelFactory.increaseLevel();
                initAfterLevelChanged();
                levelHeight++;
            }
        }

        // update the game state
        game.gameNeedsRedraw();
    }

    // change the direction of the snake
    public void changeDir(MoveDirection direction) {
        level.changeDir(direction);
    }

    // cancel the timer
    public void cancelTimer() {
        timer.cancel();
    }

    // get the level height
    public int getLevelHeight() {
        return this.levelHeight;
    }

    // get the number of points
    public int getPoints() {
        return this.points;
    }

    // initialize the game after the level has changed
    public void initAfterLevelChanged() {
        // cancel the current timer
        if (timer!= null) {
            timer.cancel();
        }

        // create a new timer with the new level velocity
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                processTick();
            }
        }, 500, level.getLevelVelocity());
    }
}

package ch.winel.zli.game.snake_game;

import ch.winel.zli.game.snake_game.util.MoveDirection;

import javax.swing.JPanel;
import java.awt.Graphics2D;

public class Level {
    private final Desert desert;
    private final Snake snake;
    private final Food food;
    private final Obstacles obstacles;
    private long levelVelocity = 400;

    public Level() {
        desert = new Desert();
        snake = new Snake();
        food = new Food();
        obstacles = new Obstacles();
    }

    public void draw(JPanel panel, Graphics2D g) {
        int dx = panel.getWidth() / this.desert.width;
        int dy = panel.getHeight() / this.desert.height;

        desert.draw(panel, g);
        snake.draw(g, dx, dy);
        food.draw(g, dx, dy);
        obstacles.draw(g, dx, dy);
    }

    public void changeDir(MoveDirection direction) {
        snake.setDirection(direction);
    }

    public long getLevelVelocity() {
        return levelVelocity;
    }

    public Snake getSnake() {
        return snake;
    }

    Food getFood() {
        return food;
    }

    public Obstacles getObstacles() {
        return obstacles;
    }

    public Desert getDesert() {
        return desert;
    }

    public void replaceFood() {
        food.addFood(snake.getSnakePositions(), obstacles.getObstaclePositions());
        food.removeFood(snake.getSnakePositions());
    }
    public void setLevelVelocity(long velocity) {
        this.levelVelocity = velocity;
    }
}

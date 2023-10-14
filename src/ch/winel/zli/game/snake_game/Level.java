package ch.winel.zli.game.snake_game;

import ch.winel.zli.game.snake_game.util.Coord;
import ch.winel.zli.game.snake_game.util.MoveDirection;

import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class Level {
    private static final double MIN_DISTANCE = 2;
    private final Desert desert;
    private final Snake snake;
    private final Food food;
    private final Obstacles obstacles;
    private long levelVelocity = 400;
    public final List<Coord> foodPositions;
    private final List<Coord> obstaclesPositions;

    public Level() {
        foodPositions = new ArrayList<>();
        obstaclesPositions = new ArrayList<>();
        desert = new Desert();
        snake = new Snake();
        food = new Food();
        obstacles = new Obstacles();
        addFood(snake.getSnakePositions(), getObstaclePositions());
        addObstacle(snake.getSnakePositions(), getFoodPositions());
    }

    public void draw(JPanel panel, Graphics2D g) {
        int dx = panel.getWidth() / this.desert.width;
        int dy = panel.getHeight() / this.desert.height;

        desert.draw(panel, g);
        snake.draw(g, dx, dy);
        food.draw(g, dx, dy, foodPositions);
        obstacles.draw(g, dx, dy, obstaclesPositions);
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

    public Desert getDesert() {
        return desert;
    }

    public List<Coord> getFoodPositions() {
        return foodPositions;
    }

    public List<Coord> getObstaclePositions() {
        return obstaclesPositions;
    }

    public void replaceFood() {
        addFood(snake.getSnakePositions(), getObstaclePositions());
        removeFood(snake.getSnakePositions());
    }

    // Add food and checks if food intersects with snake ore obstacle before add
    public void addFood(List<Coord> snakePositions, List<Coord> obstaclesPositions) {
        Coord randomPos;
        do {
            randomPos = desert.getRandomPosition();
        } while (snakePositions.contains(randomPos) || obstaclesPositions.contains(randomPos) || distance(snake.getHeadPosition(), randomPos) < MIN_DISTANCE);
        foodPositions.add(randomPos);
    }

    public void removeFood(List<Coord> snakePositions) {
        foodPositions.removeIf(snakePositions::contains);
    }

    // Add obstacle and checks if obstacle intersects with snake ore food before add
    public void addObstacle(List<Coord> snakePositions, List<Coord> foodPositions) {
        Coord randomPos;
        do {
            randomPos = desert.getRandomPosition();
        } while (snakePositions.contains(randomPos) || foodPositions.contains(randomPos) || distance(snake.getHeadPosition(), randomPos) < MIN_DISTANCE);
        obstaclesPositions.add(randomPos);
    }

    public void setLevelVelocity(long velocity) {
        this.levelVelocity = velocity;
    }

    private double distance(Coord c1, Coord c2) {
        int dx = c1.x - c2.x;
        int dy = c1.y - c2.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

}

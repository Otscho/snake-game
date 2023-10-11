package ch.winel.zli.game.snake_game;

import ch.winel.zli.game.snake_game.util.Coord;
import ch.winel.zli.game.snake_game.util.MoveDirection;

import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Level {
    private Desert desert;
    private Snake snake;
    private Food food;
    private Obstacles obstacles;

    public Level() {
        desert = new Desert();
        snake = new Snake();
        food = new Food();
        obstacles = new Obstacles();
    }

    public void draw(JPanel panel, Graphics2D g){
        int dx = panel.getWidth() / this.desert.width;
        int dy = panel.getHeight() / this.desert.height;
        desert.draw(panel, g);
        snake.draw(g, dx, dy);
        food.draw(g, dx, dy);
        obstacles.draw(g, dx, dy);
    }

    public void changeDir(MoveDirection direction){
        snake.setDirection(direction);
    }

    public long getLevelVelocity() {
        return 500;
    }

    Snake getSnake(){
        return snake;
    }

    Food getFood() { return food;}

    public Desert getDesert() {return desert;
    }

    public void replaceFood() {
        food.replaceFood();
    }

    public Obstacles getObstacles() {
        return obstacles;
    }
}

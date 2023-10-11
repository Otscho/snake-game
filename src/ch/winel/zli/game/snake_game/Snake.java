package ch.winel.zli.game.snake_game;

import java.awt.*;

import ch.winel.zli.game.snake_game.util.Coord;
import ch.winel.zli.game.snake_game.util.MoveDirection;

import java.util.ArrayList;
import java.util.List;


public class Snake {

    private final List<Coord> snakePos;
    private MoveDirection direction;
    private MoveDirection oldDirection;
    private boolean eat = false;

    public Snake() {
        snakePos = new ArrayList<>();
        snakePos.add(new Coord(1, 1));
        direction = MoveDirection.down;
        oldDirection = MoveDirection.down;
    }

    /**
     * draws the snake
     * @param g
     * @param dx
     * @param dy
     */
    public void draw(Graphics2D g, int dx, int dy) {
        for (int i = 0; i < snakePos.size(); i++) {
            Coord pos = snakePos.get(i);
            if (i == 0) {
                g.setColor(Color.BLUE);
                g.fillOval(
                        pos.x * dx,
                        pos.y * dy,
                        dx,
                        dy
                );
            } else {
                g.setColor(Color.red);
                g.fillRect(
                        pos.x * dx,
                        pos.y * dy,
                        dx,
                        dy
                );
            }
        }
    }

    public Coord getHeadPosition() {
        return snakePos.get(0);
    }

    public MoveDirection getDirection() {
        return direction;
    }

    public void movePosition(Coord nextPosition) {
        // add the new position of the head of the snake to the beginning of the snakePos list
        snakePos.add(0, nextPosition);
        oldDirection = direction;
        // remove the last position of the snake from the end of the snakePos list
        if (!eat) {
            snakePos.remove(snakePos.size() - 1);
        }
        this.eat = false;
    }


    /**
     * @param direction sets the direction of the snake
     */
    public void setDirection(MoveDirection direction) {
        switch (direction) {
            case up:
                if (oldDirection != MoveDirection.down) {
                    this.direction = direction;
                }
                break;
            case down:
                if (oldDirection != MoveDirection.up) {
                    this.direction = direction;
                }
                break;
            case left:
                if (oldDirection != MoveDirection.right) {
                    this.direction = direction;
                }
                break;
            case right:
                if (oldDirection != MoveDirection.left) {
                    this.direction = direction;
                }
                break;
        }
    }

   // get the coordinates of the whole snake
    public List<Coord> getSnakePositions() {
        return new ArrayList<>(snakePos);
    }

    /**
     * eat = true if snake had eaten food
     */
    public void eat() {
        this.eat = true;
    }

    /**
     * Checks if snake have self collision
     * @return true if snake hav a self collision
     */
    public boolean hasSelfCollision() {
        Coord head = getHeadPosition();
        for (int i = 1; i < snakePos.size(); i++) {
            if (head.equals(snakePos.get(i))) {
                return true;
            }
        }
        return false;
    }
}


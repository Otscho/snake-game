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
    private boolean eat;

    public Snake() {
        snakePos = new ArrayList<>();
        snakePos.add(new Coord(1,1));
        direction = MoveDirection.down;
        oldDirection = MoveDirection.down;
    }

    public void draw(Graphics2D g, int dx, int dy) {
        Coord headPosition = getHeadPosition();
        g.setColor(Color.blue);
        g.fillOval(
                headPosition.x * dx,
                headPosition.y * dy,
                dx,
                dy
        );
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
        snakePos.remove(snakePos.size() - 1);
    }

    public void setDirection(MoveDirection direction){
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
    public void eat (){
        this.eat = true;
    }
}


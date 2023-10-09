package ch.winel.zli.game.snake_game;

import ch.winel.zli.game.snake_game.util.MoveDirection;

import java.awt.*;


public class Snake {

    private MoveDirection direction;
    private MoveDirection oldDirection;

    public Snake() {
        this.direction = MoveDirection.down;
        this.oldDirection = MoveDirection.down;
    }

    public void drawHead(Graphics2D g, int positionX, int positionY, int width, int height) {
        g.setColor(Color.yellow);
        g.fillOval(positionX , positionY, width, height);
    }
    public void drawBody(Graphics2D g, int positionX, int positionY, int width, int height) {
        g.setColor(Color.GREEN);
        g.fillRect(positionX, positionY, width, height);
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

}


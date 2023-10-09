package ch.winel.zli.game.snake_game;

import ch.winel.zli.game.Game;

import javax.swing.*;
import java.awt.*;

public class SnakeGame extends Game {

    private boolean gameOver;
    private boolean gamePaused;
    private final SnakeGameLogic snakeGameLogic;

    public SnakeGame() {
        gamePaused = true;
        snakeGameLogic = new SnakeGameLogic(this);
    }
    @Override
    public void newGame() {
        System.out.println("newGame");
    }

    @Override
    public void quitGame() {
        System.out.println("quitGame");
        System.exit(0);
    }

    @Override
    public void pauseGame() {
        System.out.println("pauseGame");
        gamePaused = !gamePaused;
        gameNeedsRedraw();
    }

    @Override
    public void goUp() {
        System.out.println("goUp");
    }

    @Override
    public void goDown() {
        System.out.println("goDown");

    }

    @Override
    public void goLeft() {
        System.out.println("goLeft");
    }

    @Override
    public void goRight() {
        System.out.println("goRight");
    }

    @Override
    public void drawStatus(JPanel panel, Graphics2D g) {

    }

    @Override
    public void drawScene(JPanel panel, Graphics2D g) {
        snakeGameLogic.draw(panel, g);
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public boolean isPauseGame() {
        return gamePaused;
    }
}

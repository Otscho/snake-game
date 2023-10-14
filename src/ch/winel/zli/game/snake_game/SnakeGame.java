package ch.winel.zli.game.snake_game;

import ch.winel.zli.game.Game;
import ch.winel.zli.game.snake_game.util.MoveDirection;

import javax.swing.*;
import java.awt.*;

public class SnakeGame extends Game {
    SnakeGameLogic snakeGameLogic;
    private boolean isGameOver;
    private boolean gamePaused;


    public SnakeGame() {
        gamePaused = true;
        snakeGameLogic = new SnakeGameLogic(this);
        isGameOver = false;
    }

    @Override
    public void newGame() {
        if (snakeGameLogic != null) {
            snakeGameLogic.cancelTimer();
            this.snakeGameLogic = new SnakeGameLogic(this);
            snakeGameLogic.initAfterLevelChanged();
            if (!gamePaused) {
                gamePaused = true;
            }
            if (isGameOver) {
                isGameOver = false;
            }
            gameNeedsRedraw();
        }
    }

    @Override
    public void quitGame() {
        System.exit(0);
    }

    @Override
    public void pauseGame() {
        gamePaused = !gamePaused;
    }

    @Override
    public void goUp() {
        snakeGameLogic.changeDir(MoveDirection.up);
        gamePaused = false;
    }

    @Override
    public void goDown() {
        snakeGameLogic.changeDir(MoveDirection.down);
        gamePaused = false;
    }

    @Override
    public void goLeft() {
        snakeGameLogic.changeDir(MoveDirection.left);
        gamePaused = false;
    }

    @Override
    public void goRight() {
        snakeGameLogic.changeDir(MoveDirection.right);
        gamePaused = false;
    }

    @Override
    public void drawStatus(JPanel panel, Graphics2D g) {
        int fontSize = panel.getHeight() / 16;
        g.setFont(new Font("myFont", Font.BOLD | Font.ITALIC, fontSize));

        if (gamePaused) {
            g.drawString(
                    "Game Paused", 20, 20 + fontSize);
            gameNeedsRedraw();
        } else {
            g.drawString(
                    "Game Running", 20, 20 + fontSize);
            gameNeedsRedraw();
        }
        if (isGameOver) {
            g.drawString("Game Over", 20, 40 + 3 * fontSize);
        }

        g.drawString("Level: " + snakeGameLogic.getLevelHeight(), 20, 60 + 5 * fontSize);

        g.drawString("Your score: " + snakeGameLogic.getPoints(), 20, 80 + 7 * fontSize);
    }

    @Override
    public void drawScene(JPanel panel, Graphics2D g) {
        snakeGameLogic.draw(panel, g);
    }

    public boolean isPauseGame() {
        return gamePaused;
    }

    public void setGameOver() {
        isGameOver = true;
    }

    public boolean isGameOver() {
        return isGameOver;
    }
}


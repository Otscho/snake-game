package ch.winel.zli.game.example_game;

import java.awt.Graphics2D;

import javax.swing.JPanel;

import ch.winel.zli.game.Game;

public class ExampleGame extends Game {
    private boolean gamePaused = true;

    @Override
    public void newGame() {
        System.out.println("newGame");        
    }

    @Override
    public void quitGame() {
        System.out.println("quitGame");
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
    }
    
}

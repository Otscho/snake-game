package ch.winel.zli.game.snake_game;

public class LevelFactory {
    private int level;

    public LevelFactory() {
        this.level = 1;
    }

    public Level createLevel() {
        Level level = new Level();
        for (int i = 0; i < this.level; i++) {
            level.getFood().addFood(level.getSnake().getSnakePositions());
            level.getObstacles().addObstacle(level.getSnake().getSnakePositions());
        }
        return level;
    }

    public void increaseLevel() {
        this.level++;
    }
}
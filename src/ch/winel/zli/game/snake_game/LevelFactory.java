package ch.winel.zli.game.snake_game;

public class LevelFactory {
    private int level;

    public LevelFactory() {
        this.level = 1;
    }

    // create a harder level with more obstacles, foods and higher speed
    public Level createLevel() {
        Level level = new Level();
        for (int i = 0; i < this.level; i++) {
            level.addFood(level.getSnake().getSnakePositions(), level.getObstaclePositions());
            level.addObstacle(level.getSnake().getSnakePositions(), level.getFoodPositions());
            if (level.getLevelVelocity() > 100) {
                level.setLevelVelocity(level.getLevelVelocity() - 25);
            }
        }
       return level;
    }

    public void increaseLevel() {
        this.level++;
    }
}
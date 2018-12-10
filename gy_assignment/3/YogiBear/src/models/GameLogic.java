package models;

import storage.Database;
import storage.HighScore;

import java.util.ArrayList;

public class GameLogic {

    public Map map;
    public int level;
    public long startTime;
    private final Database database;

    public GameLogic()
    {
        newGame();
        database = new Database();
//        map.PrintMap();
    }

    public boolean isEnd()
    {
        return map.life == 0;
    }

    public void newGame()
    {
        map = new Map(10, 15);
        level = 1;
        startTime = System.currentTimeMillis();
    }

    public ArrayList<HighScore> getHighScores(){ return database.getHighScores(); }
    public void updateScores(String name)
    {
        database.storeHighScore(name, level - 1);
    }

    public boolean step(Direction d)
    {
        int stepped = map.move(d);
        if (stepped == 0) {
            map = new Map(10, 15);
            level++;
            startTime = System.currentTimeMillis();
        }
        return stepped == 1;
    }
}

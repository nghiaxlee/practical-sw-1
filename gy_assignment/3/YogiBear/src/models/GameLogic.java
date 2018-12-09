package models;

public class GameLogic {

    public Map map;
    public int level;
    public long startTime;

    public GameLogic()
    {
        newGame();
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

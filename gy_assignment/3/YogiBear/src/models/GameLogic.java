package models;

public class GameLogic {

    public Map map;
    private Map backup;
    public int level;

    public GameLogic()
    {
        newGame();
//        map.PrintMap();
    }

    public GameLogic(GameLogic g)
    {
        map = new Map(g.map);
    }

    public boolean isEnd()
    {
        return map.life == 0;
    }

    public void newGame()
    {
        map = new Map(10, 15);
        backup = new Map(map);
        level = 1;
    }

    public void restart()
    {
        map = new Map(backup);
    }

    public boolean step(Direction d)
    {
        int stepped = map.move(d);
        if (stepped == 0) {
            map = new Map(10, 15);
            level++;
            backup = new Map(map);
        }
        return stepped == 1;
    }
}

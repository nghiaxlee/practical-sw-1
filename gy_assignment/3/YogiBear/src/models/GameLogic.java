package models;

public class GameLogic {

    public Map map;

    public GameLogic()
    {
        map = new Map(10, 15);
        map.PrintMap();
    }

    public boolean step(Direction d)
    {
        boolean stepped = map.move(d);
        return stepped;
    }
}

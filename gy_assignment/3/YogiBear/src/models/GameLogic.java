package models;

public class GameLogic {

    private Map map;

    public GameLogic()
    {
        map = new Map(10, 15);
        map.PrintMap();
    }
}

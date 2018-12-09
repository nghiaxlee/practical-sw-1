package models;

public class Ranger {
    public Position pos;
    public boolean moveHorizontal;
    public Direction dir;
    private int diameter;

    public Ranger(Position pos, boolean moveHorizontal)
    {
        this.pos = pos;
        this.moveHorizontal = moveHorizontal;
        if (moveHorizontal)
            dir = Direction.LEFT;
        else
            dir = Direction.DOWN;
//        this.diameter = diameter;
    }

    public void changeDir()
    {
        if (dir == Direction.DOWN)
            dir = Direction.UP;
        else if (dir == Direction.UP)
            dir = Direction.DOWN;
        if (dir == Direction.LEFT)
            dir = Direction.RIGHT;
        else if (dir == Direction.RIGHT)
            dir = Direction.LEFT;
    }
}

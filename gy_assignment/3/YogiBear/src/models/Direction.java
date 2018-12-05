package models;

public enum Direction {
    DOWN(-1, 0), LEFT(0, -1), RIGHT(0, 1), UP(1, 0);

    public final int x, y;

    Direction(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}

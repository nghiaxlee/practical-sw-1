package models;

public enum Direction {
    UP(-1, 0), LEFT(0, -1), RIGHT(0, 1), DOWN(1, 0);
//    UP(0, -1), LEFT(-1, 0), RIGHT(1, 0), DOWN(0, 1);

    public final int x, y;

    Direction(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}

package models;

import java.util.Objects;

public class Position {
    public int x, y;
    public boolean visited;

    public Position(int x, int y)
    {
        this.x = x;
        this.y = y;
        visited = false;
    }

    public Position go(Direction d)
    {
        return new Position(x + d.x, y + d.y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return 1000 * x + y;
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

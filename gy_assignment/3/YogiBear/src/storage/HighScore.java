package storage;

import java.util.Objects;

public class HighScore {
    public final String player;
    public final int level;

    public HighScore(String player, int level)
    {
        this.player = player;
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HighScore highScore = (HighScore) o;
        return level == highScore.level &&
                Objects.equals(player, highScore.player);
    }

    @Override
    public int hashCode() {
        int hash = 42;
        hash += player.hashCode() + hash * level;
        return hash;
    }

    @Override
    public String toString() {
        return "HighScore{" +
                "player='" + player + '\'' +
                ", level=" + level +
                '}';
    }
}

package storage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class Database {
    private final String table = "highscores";
    private final Connection conn;
    private final HashMap<String, Integer> highScores;

    public Database()
    {
        Connection c = null;
        try {
            c = ConnectionFactory.getConnection();
        } catch (Exception ex) {
            System.out.println("No connection");
        }
        this.conn = c;
        highScores = new HashMap<>();
        loadHighScores();
    }

    public boolean storeHighScore(String player, int level)
    {
        boolean doUpdate = true;
        if (highScores.containsKey(player))
        {
            doUpdate = level > highScores.get(player);
        }
        if (doUpdate)
        {
            highScores.remove(player);
            highScores.put(player, level);
            return storeToDatabase(player, level) > 0;
        }
        return false;
    }

    public ArrayList<HighScore> getHighScores()
    {
        ArrayList<HighScore> h = new ArrayList<>();
        for(String name: highScores.keySet())
        {
            h.add(new HighScore(name, highScores.get(name)));
        }
        return h;
    }

    private void loadHighScores()
    {
        try (Statement stmt = conn.createStatement())
        {
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + table);
            while (rs.next())
            {
                String player = rs.getString("Name");
                int level = rs.getInt("Level");
                highScores.put(player, level);
            }
        } catch (Exception e) {
            System.out.println("loadHighScores error");
        }
    }

    private int storeToDatabase(String player, int level)
    {
        try (Statement stmt = conn.createStatement())
        {
            String s = "INSERT INTO " + table + "(Name, Level) " +
                    "VALUES('" + player + "'," + level +
                    ") ON DUPLICATE KEY UPDATE Level=" + level;
        } catch (Exception e) {
            System.out.println("storeToDB error");
        }
        return 0;
    }

}

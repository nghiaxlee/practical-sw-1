package models;

import java.util.HashMap;
import java.util.Random;

public class Map {

    public final int R;
    public final int C;
    public Position player;
    public final Element[][] grids;
    public final int num_basket;
    public HashMap<Position, Boolean> collected;
    private final Random rand = new Random(42);

    public Map(int R, int C)
    {
        this.R = R;
        this.C = C;
        grids = new Element[R][C];
        num_basket = rand.nextInt(R * C / 2) + 1;
        player = new Position(0, 0);
        collected = new HashMap<>();
        GenMap();
    }

    public void GenMap()
    {
        // Allocate baskets.
        for(int i = 0; i < num_basket; ++i)
        {
            int x, y;
            Position pos;
            do {
                x = rand.nextInt(R);
                y = rand.nextInt(C);
                pos = new Position(x, y);
            } while (collected.get(pos) != null || pos.equals(player));
            collected.put(pos, false);
            grids[x][y] = Element.BASKET;
            // TODO: Find path to (0, 0)
        }
    }

    public void PrintMap()
    {
        System.out.println(R + " " + C);
        System.out.println(num_basket);
        System.out.println(collected.size());
        for(Position pos: collected.keySet())
        {
            System.out.println(pos);
        }
        for(int i = 0; i < R; ++i)
        {
            for (int j = 0; j < C; ++j)
                System.out.print(grids[i][j] + " ");
            System.out.println();
        }
    }
}

package models;

import java.util.*;

public class Map {

    public final int R;
    public final int C;
    public final int num_basket;
    public int num_obstacle;
    public int num_ranger;
    public int num_step;
    public int point;
    public Position player;
    public ArrayList<Direction> dir = new ArrayList<>(
            Arrays.asList(Direction.DOWN, Direction.UP, Direction.LEFT, Direction.RIGHT));
    public final Element[][] grids;
    public boolean[][] in_path; // in_path[i][j] == true => Cannot has obstacle.
    private Position[][] visited; // if (i, j) is visited, then the array will store its parent.
    public HashMap<Position, Boolean> collected;
    private final Random rand = new Random(42);

    public Map(int R, int C)
    {
        this.R = R;
        this.C = C;
        num_basket = rand.nextInt(R * C / 2) + 1;
        num_ranger = 0;
        num_obstacle = 0;
        num_step = 0;
        point = 0;
        collected = new HashMap<>();
        grids = new Element[R][C];
        in_path = new boolean[R][C];
        visited = new Position[R][C];
        for(int i = 0; i < R; ++i)
            for(int j =0; j < C; ++j)
            {
                grids[i][j] = Element.EMPTY;
                in_path[i][j] = false;
            }
        player = new Position(0, 0);
        in_path[0][0] = true;
        GenMap();
    }

    public void GenMap()
    {
        // DONE: Find path to (0, 0)
        Bfs();
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
            FillPath(pos);
        }
        // Allocate obstacles.
        for(int i = 0; i < R; ++i)
            for(int j = 0; j < C; ++j)
                if (!in_path[i][j] && rand.nextInt(2) == 1)
                {
                    grids[i][j] = rand.nextInt(2) == 0 ? Element.HILL : Element.TREE;
                    num_obstacle++;
                }
    }

    private void Bfs()
    {
        Queue<Position> q = new LinkedList<>();
        q.add(player);
        visited[player.x][player.y] = player;
        while (!q.isEmpty())
        {
            Position u = q.remove();
            Collections.shuffle(dir); // So that it moves unpredictable.
            for(Direction d: dir)
            {
                Position v = u.go(d);
                if (Valid(v) && visited[v.x][v.y] == null)
                {
                    q.add(v);
                    visited[v.x][v.y] = u;
                }
            }
        }
    }

    private void FillPath(Position pos)
    {
        while (!pos.equals(player))
        {
            in_path[pos.x][pos.y] = true;
            pos = visited[pos.x][pos.y];
        }
    }

    private boolean Valid(Position u)
    {
        return u.x >= 0 && u.y >= 0 && u.x < R && u.y < C;
    }

    private boolean isFree(Position u)
    {
        if (!Valid(u))
            return false;
        Element e = grids[u.x][u.y];
        if (e == Element.BASKET)
        {
            point++;
            grids[u.x][u.y] = Element.EMPTY;
            return true;
        }
        return e == Element.EMPTY || e == Element.BASKET;
    }

    public boolean move(Direction d)
    {
        Position cur = player;
        Position nxt = cur.go(d);
        if (isFree(nxt))
        {
            player = nxt;
            num_step++;
            return true;
        }
        return false;
    }

    public void PrintMap()
    {
        System.out.println(R + " " + C);
//        System.out.println(num_basket);
//        System.out.println(collected.size());
//        for(Position pos: collected.keySet())
//        {
//            System.out.println(pos);
//        }
//        for(int i = 0; i < R; ++i)
//        {
//            for (int j = 0; j < C; ++j)
//                System.out.print(in_path[i][j] + " ");
//            System.out.println();
//        }
        for(int i = 0; i < R; ++i)
        {
            for (int j = 0; j < C; ++j)
                System.out.print(grids[i][j] + " ");
            System.out.println();
        }
    }
}

package models;

import java.util.*;

import static java.lang.Math.min;

public class Map {

    public final int R;
    public final int C;
    public final int num_basket;
    public int num_obstacle;
    public int num_ranger;
    public int life;
    public int point;
    public Position player;
    public ArrayList<Direction> dir = new ArrayList<>(
            Arrays.asList(Direction.DOWN, Direction.UP, Direction.LEFT, Direction.RIGHT));
    public ArrayList<Ranger> rangers;
    public final Element[][] grids;
    public boolean[][] in_path; // in_path[i][j] == true => Cannot has obstacle.
    public HashMap<Position, Boolean> collected;
    private final Random rand = new Random();

    public Map(int R, int C)
    {
        this.R = R;
        this.C = C;
        num_basket = rand.nextInt(R * C / 10) + 1;
        num_ranger = 0;
        num_obstacle = 0;
        point = 0;
        life = 3;
        collected = new HashMap<>();
        grids = new Element[R][C];
        in_path = new boolean[R][C];
        for(int i = 0; i < R; ++i)
            for(int j =0; j < C; ++j)
            {
                grids[i][j] = Element.EMPTY;
                in_path[i][j] = false;
            }
        player = new Position(0, 0);
        in_path[0][0] = true;
        rangers = new ArrayList<>();
        GenMap();
    }

    public Map(Map m)
    {
        R = m.R;
        C = m.C;
        num_basket = m.num_basket;
        num_ranger = m.num_ranger;
        num_obstacle = m.num_obstacle;
        collected = new HashMap<>(m.collected);
        grids = new Element[R][C];
        in_path = new boolean[R][C];
        player = new Position(0, 0);
        rangers = new ArrayList<>(m.rangers); // BUG
        for(int i = 0; i < R; ++i)
            for(int j = 0; j < C; ++j)
            {
                grids[i][j] = m.grids[i][j];
                in_path[i][j] = m.in_path[i][j];
            }
        point = 0;
        life = 3;
    }

    public void GenMap()
    {
        // DONE: Find path to (0, 0)
        Position[][] visited = new Position[R][C]; // if (i, j) is visited, then the array will store its parent.
        Bfs(visited);
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
            FillPath(pos, visited);
        }
        // Allocate obstacles.
        for(int i = 0; i < R; ++i) {
            for (int j = 0; j < C; ++j)
                if (!in_path[i][j] && rand.nextInt(2) == 1) {
                    grids[i][j] = rand.nextInt(2) == 0 ? Element.HILL : Element.TREE;
                    num_obstacle++;
                }
        }
        // Allocate ranger
        num_ranger = 2; // min(rand.nextInt(5) + 1, R * C - num_obstacle - num_basket);
        boolean[] col = new boolean[C];
        boolean[] row = new boolean[R];
        for(int i = 4; i < R; i += 2)
        {
            for(int j = 0; j < C; ++j)
            {
                if (row[i])
                    break;
                row[i] = AddRanger(i, j, true);
            }
        }
        num_ranger += 2;
        for(int j = C - 1; j >= 4; j -= 2)
        {
            for(int i = 1; i < R; ++i)
            {
                if (col[j])
                    break;
                col[j] = AddRanger(i, j, false);
            }
        }
    }

    private Position goFurthest(Position cur, Direction d)
    {
        Position nxt = cur.go(d);
        while (isFree(nxt, false))
        {
            cur = nxt;
            nxt = cur.go(d);
        }
        return cur;
    }

    private int diameter(Position pos, boolean horizontal)
    {
        Position cur = new Position(pos.x, pos.y);
        Position sentinel;
        Direction d;
        if (horizontal)
        {
            d = Direction.LEFT;
            cur = goFurthest(cur, d);
            sentinel = new Position(cur.x, cur.y);
            d = Direction.RIGHT;
            cur = goFurthest(cur, d);
            return cur.y - sentinel.y + 1;
        }
        else
        {
            d = Direction.UP;
            // Why goFurthest need to return Position?? I thought cur was passed by reference??
            cur = goFurthest(cur, d);
            sentinel = new Position(cur.x, cur.y);
            d = Direction.DOWN;
            cur = goFurthest(cur, d);
            return cur.x - sentinel.x + 1;
        }
    }

    private boolean AddRanger(int i, int j, boolean horizontal)
    {
        if (rangers.size() >= num_ranger)
            return false;
        Position pos = new Position(i, j);
        if (grids[i][j] != Element.BASKET && !player.equals(pos) && diameter(pos, horizontal) > 2)
        {
            if (rand.nextInt(2) == 0)
                return false;
            grids[i][j] = Element.RANGER;
            rangers.add(new Ranger(pos, horizontal));
            return true;
        }
        return false;
    }

    private void Bfs(Position[][] visited)
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

    private void FillPath(Position pos, Position[][] visited)
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

    private boolean isFree(Position u, boolean isPlayer)
    {
        if (!Valid(u))
            return false;
        Element e = grids[u.x][u.y];
        if (e == Element.BASKET)
        {
            if (!isPlayer)
                return true;
            point++;
            collected.remove(u);
            grids[u.x][u.y] = Element.EMPTY;
            return true;
        }
        return e == Element.EMPTY;
    }

    public int move(Direction d)
    {
        Position cur = player;
        Position nxt = cur.go(d);
        if (isFree(nxt, true))
        {
            if (point == num_basket)
                return 0;
            player = nxt;
            return 1;
        }
        return -1;
    }

    public void moveRanger()
    {
        for(Ranger r: rangers) {
            Position nxt = r.pos.go(r.dir);
            if (isFree(nxt, false)) {
                grids[r.pos.x][r.pos.y] = collected.get(r.pos) == null ? Element.EMPTY : Element.BASKET;
                r.pos = nxt;
                grids[r.pos.x][r.pos.y] = Element.RANGER;
            } else {
                r.changeDir();
            }
        }
    }

    private boolean isCollide(Position tmp)
    {
        if (tmp.equals(player)) {
            life--;
            player = new Position(0, 0);
            return true;
        }
        return false;
    }

    public void checkCollide()
    {
        for(Ranger r: rangers)
        {
            isCollide(r.pos);
            for(Direction d: dir)
            {
                if (r.moveHorizontal && d != Direction.DOWN && d != Direction.UP) {
                    Position tmp = r.pos.go(d);
                    isCollide(tmp);
                }
                if (!r.moveHorizontal && d != Direction.RIGHT && d != Direction.LEFT) {
                    Position tmp = r.pos.go(d);
                    isCollide(tmp);
                }
            }
        }
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

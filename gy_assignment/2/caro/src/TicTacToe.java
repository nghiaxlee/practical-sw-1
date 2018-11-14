import util.MyPair;

import java.util.ArrayList;
import java.util.Collections;

import static java.lang.Math.max;

public class TicTacToe {

    private int n;
    private int[][] grids;
    private int player;
    private int winner;
    private ArrayList<MyPair<Integer, Integer>>[] pos;
    private final int[] xi = {0, 1, 1, 1};
    private final int[] yi = {1, 1, 0, -1};
    private final char[] val = {'O', 'X', '.'};

    public TicTacToe(int sz)
    {
        n = sz;
        grids = new int[n][n];
        for(int i = 0; i < n; ++i)
            for(int j = 0; j < n; ++j)
                grids[i][j] = 2; // 2 = empty
        player = 1; // 1 = X, 0 = O
        winner = -1;
        pos = (ArrayList<MyPair<Integer, Integer>>[]) new ArrayList[2];
        for(int i = 0; i < 2; ++i)
            pos[i] = new ArrayList<>();
    }

    /**
     *
     * @param row
     * @param col
     * @return
     */
    public ArrayList<MyPair<Integer, Integer>> step(int row, int col)
    {
        ArrayList<MyPair<Integer, Integer>> deleted = new ArrayList<>();
        if (grids[row][col] != 2)
            return deleted;
        grids[row][col] = player;
        int cnt = countConsecutive(row, col);
//        System.out.println(cnt);
        MyPair<Integer, Integer> rem;
        switch (cnt)
        {
            case 5:
                foundWinner(player);
                break;
            case 4:
                Collections.shuffle(pos[player]);
                rem = pos[player].get(0);
                grids[rem.first][rem.second] = 2;
                deleted.add(rem);
                pos[player].remove(0);
            case 3:
                Collections.shuffle(pos[player]);
                rem = pos[player].get(0);
                grids[rem.first][rem.second] = 2;
                deleted.add(rem);
                pos[player].remove(0);
                break;
        }
        rem = new MyPair<>(row, col);
        pos[player].add(rem);
        player ^= 1;
        return deleted;
    }

    private int countConsecutive(int row, int col)
    {
        int res = 0;
        int x, y, tmp;
        for(int i = 0; i < 4; ++i)
        {
            tmp = 0;
            for(int j = -1; j <= 1; j += 2)
            {
                // Go backward(-1) and forward(1).
                x = row; y = col;
                while (isValid(x, y) && grids[x][y] == grids[row][col])
                {
                    ++tmp;
                    x += j * xi[i];
                    y += j * yi[i];
                }
            }
            tmp -= 1; // [row][col] counted 2 times.
            res = max(res, tmp);
        }
        return res;
    }

    private boolean isValid(int x, int y)
    {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    private void foundWinner(int player)
    {
        winner = player;
        return;
    }

    public int getWinner() {
        return winner;
    }

    public char getName(int player)
    {
        return val[player];
    }

    public int getPlayer() {
        return player;
    }

    public void print()
    {
        for(int i = 0; i < n; ++i)
        {
            for(int j = 0 ; j < n; ++j)
            {
                System.out.print(val[grids[i][j]]);
            }
            System.out.println();
        }
    }
}

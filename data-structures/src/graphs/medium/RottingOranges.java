package graphs.medium;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    class Pair {
        int row;
        int col;
        int tm;

        Pair(int _row, int _col, int _level) {
            this.row = _row;
            this.col = _col;
            this.tm = _level;
        }
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int fresh = 0;
        int[][] visited = new int[n][m];

        Queue<Pair> q = new LinkedList<>();

        for (int i=0; i<n;i++) {
            for (int j=0; j<m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i,j,0));
                    visited[i][j] = 2;
                } else if (grid[i][j] == 1) {
                    fresh++;
                } else {
                    visited[i][j] = 0;
                }
            }
        }

        int time = 0;
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};
        int cnt = 0;
        while(!q.isEmpty()) {
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().tm;
            time = Math.max(time, t);
            q.remove();


            for (int i=0; i<4; i++) {
                int nrow = r + dRow[i];
                int ncol = c + dCol[i];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && visited[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                    q.add(new Pair(nrow, ncol, t+1));
                    visited[nrow][ncol] = 2;
                    cnt++;
                }
            }
        }

        if (cnt != fresh) return -1;
        return time;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {2,1,1},
                {1,1,0},
                {0,1,1}
        };

        RottingOranges maxAreaOfIsland = new RottingOranges();
        System.out.println(maxAreaOfIsland.orangesRotting(grid));
    }
}

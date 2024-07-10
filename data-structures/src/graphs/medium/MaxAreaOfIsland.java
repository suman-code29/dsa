package graphs.medium;

import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaOfIsland {
    int res = 0;

    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int result = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    result = bfs(i, j, grid, visited);
                    res = Math.max(result, res);
                }
            }
        }
        return res;
    }

    class Pair {
        private final int first;
        private final int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public int getFirst() {
            return first;
        }

        public int getSecond() {
            return second;
        }
    }

    public int bfs(int row, int col, int[][] grid, boolean[][] visited) {
        visited[row][col] = true;
        int temp = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));
        int n = grid.length;
        int m = grid[0].length;

        int[] dRow = {-1, 1, 0, 0}; // Direction vectors for row
        int[] dCol = {0, 0, -1, 1}; // Direction vectors for column

        while (!q.isEmpty()) {
            int r = q.peek().getFirst();
            int c = q.peek().getSecond();
            q.remove();
            temp++;

            for (int i = 0; i < 4; i++) { // Loop through all four directions
                int nrow = r + dRow[i];
                int ncol = c + dCol[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && !visited[nrow][ncol] && grid[nrow][ncol] == 1) {
                    visited[nrow][ncol] = true;
                    q.add(new Pair(nrow, ncol));
                }
            }
        }
        return temp;
    }


    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };

        MaxAreaOfIsland maxAreaOfIsland = new MaxAreaOfIsland();
        System.out.println(maxAreaOfIsland.maxAreaOfIsland(grid));
    }

}

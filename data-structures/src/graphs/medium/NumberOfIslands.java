package graphs.medium;

import graphs.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        char[][] visited = new char[rows][cols];
        int result = 0;

        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if (visited[i][j] == 0 && grid[i][j] == '1') {
                    bfs(i,j,grid, visited);
                    result++;
                }
            }
        }
        return result;
    }

    public void bfs(int row, int col, char[][] grid, char[][] visited) {
        visited[row][col] = 1;
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(row, col));
        int n = grid.length;
        int m = grid[0].length;

        while(!q.isEmpty()) {
            int r = q.peek().getFirst();
            int c = q.peek().getSecond();
            q.remove();

            for (int i=-1; i<=1; i++) {
                for (int j=-1; j<=1; j++) {
                    int nrow = r + i;
                    int ncol = c + j;

                    if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && visited[i][j] == 0 && grid[i][j] == 'i') {
                        visited[i][j] = 1;
                        q.add(new Pair(i,j));
                    }
                }
            }
        }
    }
}

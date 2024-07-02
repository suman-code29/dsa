package backtracking.medium;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class WordSearch {

    public class Pair {
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return first == pair.first && second == pair.second;
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
    }

//    public boolean exist(char[][] board, String word) {
//        int rows = board.length;
//        int cols = board[0].length;
//        Set<Pair> path = new HashSet<>();
//
//        for (int i=0; i<rows ; i++) {
//            for(int j=0; j<cols; j++) {
//                if (solve(i, j, 0, word, rows, cols, board, path)) {
//                    return true;
//                }
//            }
//        }
//
//        return false;
//    }
//
//    private boolean solve(int r, int c, int idx, String word, int rows, int cols, char[][] board, Set<Pair> path) {
//        if (idx == word.length()) {
//            return true;
//        } else if (r < 0 || c < 0 || r >= rows || c >= cols || word.charAt(idx) != board[r][c] || path.contains(new Pair(r,c))) {
//            return false;
//        }
//
//        path.add(new Pair(r,c));
//        boolean result = (solve(r+1, c, idx+1, word, rows, cols, board, path)
//                || solve(r-1, c, idx+1, word, rows, cols, board, path)
//                || solve(r, c+1, idx+1, word, rows, cols, board, path)
//                || solve(r, c-1, idx+1, word, rows, cols, board, path));
//
//        path.remove(new Pair(r,c));
//
//        return result;
//    }

    public static void main(String[] args) {
        char[][]board = new char[][]{{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
        WordSearch wordSearch = new WordSearch();
        System.out.println(wordSearch.exist(board, "SEE"));
    }

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0) && backtrack(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean backtrack(char[][] board, String word, int row, int col, int index) {
        if (index == word.length()) {
            return true;
        }

        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(index)) {
            return false;
        }

        char temp = board[row][col];
        board[row][col] = '#'; // Mark as visited

        boolean found = backtrack(board, word, row + 1, col, index + 1) ||
                backtrack(board, word, row - 1, col, index + 1) ||
                backtrack(board, word, row, col + 1, index + 1) ||
                backtrack(board, word, row, col - 1, index + 1);

        board[row][col] = temp; // Unmark as visited

        return found;
    }
}

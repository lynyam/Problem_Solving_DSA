class Solution {
    int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int L = word.length();
        boolean[][] seen = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    seen[i][j] = true;
                    if (backtracking(i, j, 1, seen, word, board)) return (true);
                    seen[i][j] = false;
                }
            }
        }
        return (false);
    }

    public boolean backtracking(int i, int j, int index, boolean[][] seen, String word, char[][] board) {
        //base case
        if (index == word.length()) return (true);

        // call each neighbor
        for (int[] neighbor : directions) {
            int x = neighbor[0] + i;
            int y = neighbor[1] + j;
            if (isValid(x, y, board.length, board[0].length) && !seen[x][y]) {
                if (board[x][y] == word.charAt(index)) {
                    seen[x][y] = true;
                    if (backtracking(x, y, index + 1, seen, word, board)) return (true);
                    seen[x][y] = false;
                }
            }
        }
        return (false);
    }

    public boolean isValid(int x, int y, int m, int n) {
        return (x >= 0 && x < m && y >= 0 && y < n);
    }
}
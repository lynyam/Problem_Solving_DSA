class Solution {
    int[][] directions = new int[][]{
        {-1, 0}, {1, 0},
        {0, -1}, {0, 1}
    };
    int m;
    int n;
    public boolean isValid(int x, int y) {
        return (x >= 0 && x < m && y >= 0 && y < n);
    }

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        int i = 0;
        while (i < m) {
            int j = 0;
            while (j < n) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] seen = new boolean[m][n];
                    seen[i][j] = true;
                    if (backtrack(i, j, 1, board, seen, word))
                        return (true);
                }
                j++;
            }
            i++;
        }
        return (false);
    }

    public boolean backtrack(int x, int y, int start, char[][] board, boolean[][] seen, String word) {
        if (start == word.length())
            return (true);
        boolean ans = false;
        for (int[] dir : directions) {
            int row = x + dir[0];
            int col = y + dir[1];
            if (isValid(row, col) && !seen[row][col] && board[row][col] == word.charAt(start)) {
                seen[row][col] = true;
                ans |= backtrack(row, col, start + 1, board, seen, word);
                seen[row][col] = false;
            }
        }
        return (ans);
    }
}
/**
    - mxn of char board[][] ans string word
    - ret true id word exists in the  grid
    - construct word with seq adj cells
    - use letter once
    basecase i = word.length
                return (true)
    for (dir : directions) 
        if (!isValid(x, y) || set.contains(x#y))
            continue ;
 */
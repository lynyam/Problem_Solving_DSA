class Solution {
    int m;
    int n;
    int [][] directions = new int[][] {
        {1, 0}, {0, 1},
        {-1, 0}, {0, -1}
    };
    boolean[][] seen;
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int ans = 0;
        seen = new boolean[m][n];
        int i = 0;
        int j = 0;
        
        while (i < m) {
            j = 0;
            while (j < n) {
                if (grid[i][j] == '1' && !seen[i][j]) {
                    seen[i][j] = true;
                    ans++;
                    dfs(i, j, grid);
                }
                j++;
            }
            i++;
        }
        return (ans);
    }

    public void dfs(int row, int col, char[][] grid) {
        for (int[] direction : directions) {
            int x = direction[0] + row;
            int y = direction[1] + col;
            if (isValid(x, y) && grid[x][y] == '1' && !seen[x][y]) {
                seen[x][y] = true;
                dfs(x, y, grid);
            }
        }
    }

    public boolean isValid(int x, int y) {
        return (x >= 0 && x < m && y >= 0 && y < n);
    }
}
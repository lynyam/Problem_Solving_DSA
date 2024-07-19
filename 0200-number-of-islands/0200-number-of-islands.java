class Solution {
    int[][] directions = new int[][]{
        {1, 0},
        {-1, 0},
        {0, -1},
        {0, 1}};
    boolean[][] seen;
    int n;
    int m;
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int ans = 0;
        int i = 0;
        int j = 0;
        seen = new boolean[n][n];

        while (i < m) {
            j = 0;
            while (j < n) {
                if (!seen[i][j] && grid[i][j] == '1') {
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

    public boolean isValid(int x, int y) {
        return (x >= 0 && x < m && y >= 0 && y < n && !seen[x][y]);
    }

    public void dfs(int row, int col, char[][] grid) {
        for (int[] direction : directions) {
            int neiRow = row + direction[0];
            int neiCol = col + direction[1];
            if (isValid(neiRow, neiCol) && grid[neiRow][neiCol] == '1') {
                seen[neiRow][neiCol] = true;
                dfs(neiRow, neiCol, grid);
            }
        }
    }
}
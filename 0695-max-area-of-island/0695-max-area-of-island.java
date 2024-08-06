class Solution {
    int n;
    int m;
    boolean[][] seen;
    int[][] directions = new int[][] {
        {1, 0}, {0, 1},
        {-1, 0}, {0, -1}
    };

    public boolean isValid(int x, int y) {
        return (x >= 0 && x < m && y >= 0 && y < n);
    }

    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        seen = new boolean[m][n];
        int i = 0;
        int j = 0;
        int ans = 0;

        while (i < m) {
            j = 0;
            while (j < n) {
                int land = grid[i][j];
                if (land == 1 && !seen[i][j]) {
                    ans = Math.max(ans, dfs(i, j, grid));
                }
                j++;
            }
            i++;
        }
        return (ans);
    }

    public int dfs(int row, int col, int[][] grid) {
        int ans = 1;
        seen[row][col] = true;
        for (int[] direction : directions) {
            int x = row + direction[0];
            int y = col + direction[1];
            if (isValid(x, y) && !seen[x][y] && grid[x][y] == 1) {
                ans += dfs(x, y, grid);
            }
        }
        return (ans);
    }
}
/*
    - binary mat mxn grid
    - island = group 1 (1 = land) connected 4 dir (hor and vert)
    - all 4 edge in water
    - area island = nb of cells = 1 in island
    - ret : max area in grid or 0
*/
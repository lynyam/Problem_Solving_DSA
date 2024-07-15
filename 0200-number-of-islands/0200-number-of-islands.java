class Solution {
    int ans = 0;
    int m;
    int n;
    public int numIslands(char[][] grid) {
        int i = 0;
        int j = 0;
        m = grid.length;
        n = grid[0].length;
        boolean[][] seen = new boolean[m][n];

        while (i < m) {
            j = 0;
            while (j < n) {
                if (grid[i][j] == '1' && !seen[i][j]) {
                    ans++;
                    dfs(i, j, grid, seen);
                }
                j++;
            }
            i++;
        }
        return (ans);
    }

    public void dfs(int i, int j, char[][] grid, boolean[][] seen) {
        if (seen[i][j] || grid[i][j] == '0')
            return ;
        seen[i][j] = true;
        if (i - 1 >= 0)
            dfs(i - 1, j, grid, seen);
        if (i + 1 < m)
            dfs(i + 1, j, grid, seen);
        if (j + 1 < n)
            dfs(i, j + 1, grid, seen);
        if (j - 1 >= 0)
            dfs(i, j - 1, grid, seen);
    }
}
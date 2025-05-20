class Solution {
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    result = helper(i, j, grid);
                    break ;
                }
            }
        }
        return (result);
    }
    int [][] neighbors = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public boolean isValid(int x, int y, int[][] grid) {
        return (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1);
    }

    public int helper(int i, int j, int[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) return (1);
        if (grid[i][j] == -1) return (0);
        grid[i][j] = -1;
        int result = 0;
        for (int[] neighbor : neighbors) {
            int x = i + neighbor[0];
            int y = j + neighbor[1];
            result += helper(x, y, grid);
        }
        return (result);
    }

}
class Cell {
    int row;
    int col;
    int obst;
    public Cell(int x, int y, int o) {
        row = x;
        col = y;
        obst = o;
    }
}

class Solution {
    int m;
    int n;
    int[][] directions = new int[][] {
        {1, 0}, {0, 1},
        {-1, 0}, {0, -1}
    };
    boolean[][][] seen;

    public boolean isValid(int x, int y) {
        return (x >= 0 && x < m && y >= 0 && y < n);
    }

    public int shortestPath(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;
        seen = new boolean[m][n][k + 1];
        Queue<Cell> queue = new LinkedList<>();
        int level = 0;

        seen[0][0][0] = true;
        queue.add(new Cell(0, 0, 0));
        while (!queue.isEmpty()) {
            int i = 0;
            int size = queue.size();
            while (i < size) {
                Cell cell = queue.remove();
                int row = cell.row;
                int col = cell.col;
                int obst = cell.obst;
                if (row == m - 1 && col == n - 1)
                    return (level);
                for (int[] direction : directions) {
                    int x = direction[0] + row;
                    int y = direction[1] + col;
                    if (isValid(x, y)) {
                        int neiObst = grid[x][y] == 1 ? obst + 1 : obst;
                        if (neiObst <= k && !seen[x][y][neiObst]) {
                            seen[x][y][neiObst] = true;
                            queue.add(new Cell(x, y, neiObst));
                        }
                    }
                }
                i++;
            }
            level++;
        }
        return (-1);
    }
}
/*
    - integer mat[m][n]
        - mat[i][j] = 0 => empty || mat[i][j] = 1 => obstacle
    - directions moov in on step (1, 0) (0, 1) (-1, 0) (0, -1) &&  cell == 0
    - ret : minimum number of step: upper left (0, 0) --> right corner (m-1)(n-1)
        - contrains: you can eliminate at most k obstacles
        - ret -1 if it is not possible
*/
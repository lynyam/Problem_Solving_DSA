class Cell {
    int row;
    int col;
    int obs;
    public Cell(int row, int col, int obs) {
        this.row = row;
        this.col = col;
        this.obs = obs;
    }
}
    
class Solution {
    int[][] directions = new int[][] {
        {1, 0},{0, 1},
        {-1, 0},{0, -1}
    };
    int n;
    int m;

    public boolean isValid(int x, int y) {
        return (x >= 0 && x < m && y >= 0 && y < n);
    }

    public int shortestPath(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;
        boolean[][][] seen = new boolean[m][n][k + 1];
        int ans = Integer.MAX_VALUE;
        if ((grid[0][0] == 1 || grid[m - 1][n - 1] == 1) && k == 0)
            return (-1);
        if (grid[0][0] == 1)
            k--;
        Queue<Cell> queue = new LinkedList<>();
        queue.add(new Cell(0, 0, 0));
        seen[0][0][0] = true;
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int i = 0;
            while (i < size) {
                Cell cell = queue.remove();
                int row = cell.row;
                int col = cell.col;
                int obs = cell.obs;
                if (row == m - 1 && col == n - 1 && obs <= k) {
                    return (level);
                }
                for (int[] direction : directions) {
                    int x = row + direction[0];
                    int y = col + direction[1];
                    if (isValid(x, y)) {
                        int neiObs = grid[x][y] == 1 ? obs + 1 : obs;
                        if (neiObs <= k && !seen[x][y][neiObs]) {
                            seen[x][y][neiObs] = true;
                            queue.add(new Cell(x, y, neiObs));
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
[0,0],
[1,0],
[1,0],
[1,0],
[1,0],
[1,0],
[0,0],
[0,1],
[0,1],
[0,1],
[0,0],
[1,0],
[1,0],
[0,0]]
*/
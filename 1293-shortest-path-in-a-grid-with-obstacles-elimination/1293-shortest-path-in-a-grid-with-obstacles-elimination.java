class Cell {
    int row;
    int col;
    int obst;

    public Cell(int row, int col, int obst) {
        this.row = row;
        this.col = col;
        this.obst = obst;
    }    
}

class Solution {
    int[][] directions = new int[][]{
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
        boolean[][][] seen = new boolean[m][n][k+1];
        int level = 0;
        Queue<Cell> queue = new LinkedList<>();

        queue.add(new Cell(0, 0, 0));
        seen[0][0][0] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int i = 0;
            while (i < size) {
                Cell cell = queue.remove();
                int row = cell.row;
                int col = cell.col;
                int obst = cell.obst;
                if (row == m - 1 && col == n - 1 && obst <= k)
                    return (level);
                for (int[] direction : directions) {
                    int x = row + direction[0];
                    int y = col + direction[1];
                    if (isValid(x, y)) {
                        int neibObst = grid[x][y] == 1 ? obst + 1 : obst;
                        if (neibObst <= k && !seen[x][y][neibObst]) {
                            seen[x][y][neibObst] = true;
                            queue.add(new Cell(x, y, neibObst));
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
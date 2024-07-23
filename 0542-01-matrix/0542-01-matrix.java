class Cell {
    int row;
    int col;
    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    int m;
    int n;
    int[][] directions = new int[][]{
        {1, 0}, {0, 1},
        {-1, 0}, {0, -1}
    };

    public boolean isValid(int x, int y) {
        return (x >= 0 && x < m && y >= 0 && y < n);
    }

    public int[][] updateMatrix(int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        int i = 0;
        int j = 0;

        while (i < m) {
            j = 0;
            while (j < n) {
                if (mat[i][j] != 0) {
                    bfs(i, j, mat);
                }
                j++;
            }
            i++;
        }
        return (mat);
    }

    public void bfs(int row, int col, int[][] mat) {
        Queue<Cell> queue = new LinkedList<>();
        boolean[][] seen = new boolean[m][n];
        queue.add(new Cell(row, col));
        int level = 0;
        seen[row][col] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int i = 0;
            while (i < size) {
                Cell cell = queue.remove();
                for (int[] direction : directions) {
                    int x = cell.row + direction[0];
                    int y = cell.col + direction[1];
                    if (isValid(x, y) && !seen[x][y]) {
                        if (mat[x][y] == 0) {
                            mat[row][col] = Math.abs(row - x) + Math.abs(col - y);
                            return ;
                        }
                        seen[x][y] = true;
                        queue.add(new Cell(x, y));
                    }
                }
                i++;
            }
            level++;
        }
        return ;
    }
}
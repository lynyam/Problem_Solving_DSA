class Cell {
    int row;
    int col;
    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }    
}
class Solution {
    int n;
    int m;

    public boolean isValid(int x, int y) {
        return (x >= 0 && x < m && y >= 0 && y < n);
    }
    public int[][] updateMatrix(int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        int i = 0;
        int j = 0;
        int level = 0;
        Queue<Cell> queue = new LinkedList<>();
        boolean[][] seen = new boolean[m][n];
        int[][] directions = new int[][] {
            {1, 0},{0, 1},
            {-1, 0},{0, -1}
        };

        while (i < m) {
            j = 0;
            while (j < n) {
                if (mat[i][j] == 0) {
                    queue.add(new Cell(i,j));
                    seen[i][j] = true;
                }
                j++;
            }
            i++;
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            i = 0;
            while (i < size) {
                Cell cell = queue.remove();
                int x = cell.row;
                int y = cell.col;
                for (int[] direction : directions) {
                    int row = x + direction[0];
                    int col = y + direction[1];
                    if (isValid(row, col) && !seen[row][col]) {
                        seen[row][col] = true;
                        mat[row][col] = level + 1;
                        queue.add(new Cell(row, col));
                    }
                }
                i++;
            }
            level++;
        }
        return (mat);
    }
}
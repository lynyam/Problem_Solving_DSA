class Path {
    int row;
    int col;
    int countCel;
    public Path(int row, int col, int countCel) {
        this.row = row;
        this.col = col;
        this.countCel = countCel;
    }
}
class Solution {
    int[][] directions = new int[][]{
        {1, 0}, {-1, 0},
        {0, 1}, {0, -1},
        {1, 1}, {1, -1},
        {-1, 1}, {-1, -1}};
    int n;

    public boolean isValid(int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < n);
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        n = grid.length;
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0)
            return (-1);
        if (n == 1)
            return (1);
        Queue<Path> queue = new LinkedList<>();
        boolean[][] seen = new boolean[n][n];
        queue.add(new Path(0, 0, 1));
        while (!queue.isEmpty()) {
            int size = queue.size();
            int i = 0;
            while (i < size) {
                Path path = queue.remove();
                int row = path.row;
                int col = path.col;
                int cel = path.countCel;
                if (col == n - 1 && row == n - 1) {
                    return (cel);
                }
                for (int[] direction : directions) {
                    int neiRow = row + direction[0];
                    int neiCol = col + direction[1];
                    int neiCel = cel + 1;
                    if (isValid(neiRow, neiCol) && grid[neiRow][neiCol] == 0 && !seen[neiRow][neiCol]) {
                        seen[neiRow][neiCol] = true;
                        queue.add(new Path(neiRow, neiCol, neiCel));
                    }
                }
                i++;
            }        
        }
        return (-1);
    }
}
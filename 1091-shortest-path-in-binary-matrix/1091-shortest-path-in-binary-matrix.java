  class Path {
        int[] cell;
        int count;
        public Path(int row, int col , int count) {
            this.cell = new int[]{row, col};
            this.count = count;
        }
    }
    
    class Solution {
    int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}, {1, 1}, {-1, 1}, {1, -1},{-1, -1}};
    int n;
    boolean[][] seen;
    int ans;

    public boolean isValid(int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < n);
    }
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        ans = Integer.MAX_VALUE;
        n = grid.length;
        int length = 0;
        Queue<Path> queue = new LinkedList<>();
        seen = new boolean[n][n];

        if (n == 1) {
            return (grid[0][0] == 0 ? 1 : -1);
        }
        if (grid[0][0] == 0 && grid[n - 1][n - 1] == 0)
            queue.add(new Path(0, 0, 1));
        while (!queue.isEmpty()) {
            int i = 0;
            int size = queue.size();
            while (i < size) {
                Path path = queue.remove();
                int row = path.cell[0];
                int col = path.cell[1];
                int count = path.count;
                for (int[] direction : directions) {
                    int neiRow = row + direction[0];
                    int neiCol = col + direction[1];
                    if (isValid(neiRow, neiCol) && grid[neiRow][neiCol] == 0 && !seen[neiRow][neiCol] && !(neiRow == n - 1 && neiCol == n - 1)) {
                        seen[neiRow][neiCol] = true;
                        queue.add(new Path(neiRow, neiCol, count + 1));
                    }
                    else if (neiRow == n - 1 && neiCol == n - 1) {
                        ans = Math.min(ans, count + 1);
                    }
                }
                i++;
            }

        }
        return (ans == Integer.MAX_VALUE ? -1 : ans);
    }
}
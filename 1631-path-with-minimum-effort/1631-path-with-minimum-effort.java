class Solution {
    int[][] directions = new int[][]{
        {1, 0}, {0, 1},
        {-1, 0}, {0, -1}
    };
    int m;
    int n;

    public boolean isValid(int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < m);
    }

    public int minimumEffortPath(int[][] heights) {
        n = heights.length;
        m = heights[0].length;
        int left = 0;
        int right = 0;

        for (int[] row : heights) {
            for (int col : row) {
                right = Math.max(right, col);
            }
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(mid, 0, 0, heights, new boolean[n][m])) {
                right = mid - 1;
            }
            else
                left = mid + 1;
        }
        return (left);
    }

    public boolean check(int mid, int x, int y, int[][] heights, boolean[][] seen) {
        boolean ans = false;
        if (x == n - 1 && y == m - 1) {
            return (true);
        }
        seen[x][y] = true;
        for (int[] dir : directions) {
            int row = x + dir[0];
            int col = y + dir[1];
            if (isValid(row, col) && !seen[row][col] && Math.abs(heights[row][col] - heights[x][y]) <= mid) {
                ans |= check(mid, row, col, heights, seen);
            }
        }
        return (ans);
    }
}
/**
    - find a root with miimum effort
    - route's effort = max|cell_i - cell_i-1|
    - ret: min effort required
 */
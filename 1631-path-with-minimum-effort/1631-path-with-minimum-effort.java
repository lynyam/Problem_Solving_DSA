class Solution {
    int n;
    int m;
    int[][] directions = new int[][] {
        {-1, 0}, {0, -1},
        {1, 0}, {0, 1}
    };
    int[][] heights;
    boolean[][][] seen;

    public boolean isValid(int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < m);
    }
    public int minimumEffortPath(int[][] height) {
        this.heights = height;
        n = heights.length;
        m = heights[0].length;
        int ans = 0;
        int left = 0;
        int right = 0;
        int i = 0;

        while (i < n) {
            int j = 0;
            while (j < m) {
                right = Math.max(right, heights[i][j]);
                j++;
            }
            i++;
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(0, 0, mid, new boolean[n][m]))
                right = mid - 1;
            else
                left = mid + 1;
        }
        return (left);
    }

    public boolean check(int row, int col, int diff, boolean[][] seen) {
        boolean ans = false;
        seen[row][col] = true;
        if (row == n - 1 && col == m - 1)
            return (true);
        for (int[] direction : directions) {
            int x = row + direction[0];
            int y = col + direction[1];
            if (isValid(x, y) && Math.abs(heights[row][col] - heights[x][y]) <= diff) {
                if (!seen[x][y]) {
                    ans |= check(x, y, diff, seen);
                }
            }
        }
        return (ans);
    }
}
/**
    - heights int[rows][cols]
        - heigths[row][col] height of (cell, col)
    - start : top-level (0,0) -> bottom-right cell(rows - 1, cols - 1)
    - moove up, left, down, right, 
    - find route that requieres minimum effort
        - route's effort = max|diff(heights(i,j), heights(i', j')) on the route
    - minimun effort required to top -> bottom
    - sltion: 
        - creer un objet State(x, y, max, min)
        - HashSet<State> set
            - State init = new State(0, 0, 1, 1)
            - set.add(init)
        - dfs(init)
            - if (x= r - 1 && y = c - 1)
                ans = Math.min(ans, diff(max - min))
 */
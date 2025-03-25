class Solution {
    int[][] childrens = new int[][] {
		{-1, 0}, {0, -1},
		{1, 0}, {0, 1}
    };
	public int minimumEffortPath(int[][] heights) {
		int min  = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int m = heights.length;
		int n = heights[0].length;
		for (int[] height : heights) {
			for (int cell : height) {
				min = Math.min(min, cell);
				max = Math.max(max, cell);
            }
        }
        int right = Math.abs(max - min);
        int left = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (hasPassedDfs(0, 0, mid, m, n, heights, new boolean[m][n])) {
                right = mid - 1;
        } else
            left = mid + 1;
        }
        return (left);
    }
    public boolean hasPassedDfs(int row, int col, int mid, int m, int n, int[][] heights, boolean[][] visited) {
        if (row == m - 1 && col == n - 1)
            return (true);
        visited[row][col] = true;
        boolean result = false;
        for (int[] neighbor : childrens) {
            int neiCol = col + neighbor[1];
            int neiRow = row + neighbor[0];
            if (isValid(neiRow, neiCol, m, n) && !visited[neiRow][neiCol] && Math.abs(heights[row][col] - heights[neiRow][neiCol]) <= mid) {
                result |= hasPassedDfs(neiRow, neiCol, mid, m, n, heights, visited); 
            }
        }
        visited[row][col] = false;
        return (result);
    }

    public boolean isValid(int x, int y, int m, int n) {
        return (x >= 0 && x < m && y >= 0 && y < n);
    }
}
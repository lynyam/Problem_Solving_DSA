class Solution {
    int[][] childrens = new int[][] {
        {-1, 0}, {0, -1},
        {1, 0}, {0, 1}
    };

    public boolean isValid(int x, int y, int m, int n) {
        return (x >= 0 && x < m && y >= 0 && y < n);
    }

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        //create an arrays to store a minimum possible effort from (0, 0) to cell(i, j)
        // fill initialy all effort to inf, and effort from (0, 0) ->(0, 0) is 0
        int[][] efforts = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(efforts[i], Integer.MAX_VALUE);
        }
        efforts[0][0] = 0;
        //to make sure to already choose a best path, it very importante that for every choise we
        //choose a cell with which belong to a best path. it a cell with minimum effort from 0, 0 to it-> we use Priorytyqueue to always ensure to havee minimum.
        // add (0, 0, 0) to minHeap => (0, 0) with effort 0
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        minHeap.add(new int[]{0,0,0});

        //we poll the best path cell in minHeap until minHeap is Empty()
        //for every cell we loop on neighbor/children (up down right left). We add Children in minHeap in case who:
            // it is in boundary of heights, efforts for this children > new effort
        // if cell is bottom right return effort
        while (!minHeap.isEmpty()) {
            int[] cell = minHeap.poll();
            if (cell[0] == m - 1 && cell[1] == n - 1) return (cell[2]);
            if (efforts[cell[0]][cell[1]] < cell[2]) continue;
            for (int[] child : childrens) {
                int row = cell[0] + child[0];
                int col = cell[1] + child[1];
                if (isValid(row, col, m, n)) {
                    int effort = Math.max(cell[2], Math.abs(heights[cell[0]][cell[1]] - heights[row][col])); 
                    if (efforts[row][col] > effort) {
                        efforts[row][col] = effort;
                        minHeap.add(new int[]{row, col, effort});
                    }
                }
            }
        }
        
        return (0);
    }
}
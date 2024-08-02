class Cell {
    int x;
    int y;
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    int m;
    int n;
    int[][] directions = new int[][]{
        {1, 0}, {-1, 0},
        {0, 1}, {0, -1}
    };
    boolean[][] seen;

    public boolean isValid(int x, int y) {
        return (x >= 0 && x < m && y >= 0 && y < n && !seen[x][y]);
    }
    public int[][] updateMatrix(int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        Queue<Cell> queue = new LinkedList<>();
        seen = new boolean[m][n];
        int[][] ans = new int[m][n];
        int i = 0;
        int j = 0;
        int level = 0;

        while (i < m) {
            j = 0;
            while (j < n) {
                if (mat[i][j] == 0) {
                    seen[i][j] = true;
                    queue.add(new Cell(i, j));
                }
                j++;
            }
            i++;
        }

        while (!queue.isEmpty()) {
            int k = 0;
            int size = queue.size();
            while (k < size) {
                Cell cell = queue.remove();
                int x = cell.x;
                int y = cell.y;
                ans[x][y] = level;
                for (int[] direction : directions) {
                    int xi = x + direction[0];
                    int yi = y + direction[1];
                    if (isValid(xi, yi)) {
                        seen[xi][yi] = true;
                        queue.add(new Cell(xi, yi));
                    }
                }
                k++;
            }
            level++;
        }
        return (ans);
    }
}
/*
    - binary mat m x n mat
    - ret distance nearest 0 for each cell
    - distance btw two adj cell = 0
    - ans[i][j] = nearest 0 for mat[i][j]
        - if mat[i][j] = 0 ans[i][j] = 0;
        - start with every 0 all cell 1 in adj are ans[][] = 1
            - all cell level 1 => ans[][] = 2 ... until every thing are finish
*/
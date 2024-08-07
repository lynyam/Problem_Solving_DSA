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
    int[][] directions = new int[][]{{1,0}, {0, 1},
                                            {-1,0}, {0, -1},
                                            {1,1}, {-1, -1},
                                            {1,-1}, {-1, 1}
                                        };
    boolean[][] seen;

    public boolean isValid(int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < n);
    }
                                        
    public int shortestPathBinaryMatrix(int[][] grid) {
        n = grid.length;
        seen = new boolean[n][n];
        Queue<Cell> queue = new LinkedList<>();
        int level = 1;

        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1)
            return (-1);
        seen[0][0] = true;
        queue.add(new Cell(0, 0));
        while (!queue.isEmpty()) {
            int i = 0;
            int size = queue.size();
            while (i < size) {
                Cell cell = queue.remove();
                int row = cell.row;
                int col = cell.col;
                if (row == n - 1 && col == n - 1)
                    return (level);
                for (int[] direction : directions) {
                    int x = row + direction[0];
                    int y = col + direction[1];
                    if (isValid(x, y) && !seen[x][y] && grid[x][y] == 0) {
                        seen[x][y] = true;
                        queue.add(new Cell(x, y));
                    }
                }
                i++;
            }
            level++;
        }
        return (-1);
    }
}
/*
    - grid[][] binary matrix n x n
    - ret : length of shortest clear path (bfs) | -1 if not
        - length = number of visited cells of this path
    - clear path is path :
        - from (0, 0) cell top-left to (n-1, n-1) botom-right
    - all visited path = 0
    - adjCell 8 direction 

    result:
    -+ create an class Cell(int row, int col)
    -+ init all directions{{1,0}, {0, 1},
                           {-1,0}, {0, -1},
                           {1,1}, {-1, -1},
                           {1,-1}, {-1, 1},
                        }
    -+ create a fonction return boolean to make sure that neighbor is in matrix
    -+ check if (0, 0) is 0 or (n-1, n-1) is 0 or return -1
    -+ create ds seen[][] to store all visited path
    -+ add cell(0, 0) in path
    -+ create queue for my bfs;
    -+ add cell(0,0) in my queue
    -+ while queue is not empty()
        -+ walk throught on queue ans for each cell
            -+ if row = n-1 and y == n - 1 return (level)
            -+ for every neighbor
                -+ if it valid and neighbor.val == 0 ans never seen
                    -+ make visited
                    -+ add on queue
        - increment level
    return (-1); 


*/
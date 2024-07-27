class Cell {
    int row;
    int col;
    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    int[][] directions = new int[][]{
        {1, 0}, {0, 1},
        {-1, 0}, {0, -1}
    };
    int n;
    int m;
    char[][] maze;

    public boolean isValid(int x, int y) {
        return (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == '.');
    }

    public boolean isExit(int x, int y) {
        return (x == 0 || x == m - 1 || y == 0 || y == n - 1);
    }

    public int nearestExit(char[][] maze, int[] entrance) {
        this.maze = maze;
        m = maze.length;
        n = maze[0].length;
        boolean[][] seen = new boolean[m][n];
        Queue<Cell> queue = new LinkedList<>();
        int level = 0;

        seen[entrance[0]][entrance[1]] = true;
        queue.add(new Cell(entrance[0], entrance[1]));
        while (!queue.isEmpty()) {
            int i = 0;
            int size = queue.size();
            while (i < size) {
                Cell cell = queue.remove();
                int row = cell.row;
                int col = cell.col;
                for (int[] direction : directions) {
                    int x = row + direction[0];
                    int y = col + direction[1];
                    if (isValid(x, y) && !seen[x][y]) {
                        if (isExit(x, y))
                            return (level + 1);
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
- exit = empty cell border of the maze. not entrance
ret: number of step of shortest path (entrance-> nearest exit) or -1 if no path
*/
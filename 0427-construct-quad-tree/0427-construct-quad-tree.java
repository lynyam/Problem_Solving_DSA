/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    int[][] grid;
    public Node construct(int[][] grid) {
        this.grid = grid;
        return (solveTree(0, 0, grid.length));
    }

    public Node solveTree(int x, int y, int length) {
        if (isSame(x, y, length)) {
            return (new Node(grid[x][y] == 1, true));
        }
        Node topLeft = solveTree(x, y, length / 2);
        Node topRight = solveTree(x, y + length / 2, length / 2);
        Node bottomLeft = solveTree(x + length / 2, y, length / 2);
        Node bottomRight = solveTree(x + length / 2, y + length / 2, length / 2);
        return (new Node(true, false, topLeft, topRight, bottomLeft, bottomRight));
    }

    public boolean isSame(int x, int y, int length) {
        int val = grid[x][y];
        for (int i = x; i < x + length; i++) {
            for (int j = y; j < y + length; j++) {
                if (grid[i][j] != val)
                    return (false);
            }
        }
        return (true);
    }
}
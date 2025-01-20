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
    public Node construct(int[][] grid) {
        return (helper(grid, 0, 0, grid.length));
    }

    public Node helper(int[][] grid, int x, int y, int length) {
        if (isSame(grid, x, y, length))
            return (new Node(grid[x][y] == 1, true));
        Node topLeft = helper(grid, x, y, length / 2);
        Node topRight = helper(grid, x, y + length/ 2, length / 2);
        Node bottomLeft = helper(grid, x + length/ 2, y, length / 2);
        Node bottomRight = helper(grid, x + length / 2, y + length / 2, length / 2);
        return (new Node(false, false, topLeft, topRight, bottomLeft, bottomRight));
    }

    public boolean isSame(int[][] grid, int x, int y, int length) {
        int i = x;
        int val = grid[x][y];
        while (i < x + length) {
            int j = y;
            while (j < y + length) {
                if (grid[i][j] != val)
                    return (false);
                j++;
            }
            i++;
        }
        return (true);
    }
}
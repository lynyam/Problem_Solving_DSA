/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        List<List<Node>> levels = new ArrayList<>();
        buildLevels(root, 0, levels);
        for (List<Node> level : levels) {
            for (int i = 1; i < level.size(); i++) {
                level.get(i - 1).next = level.get(i);
            }
        }
        return (root);
    }

    public void buildLevels(Node root, int depth, List<List<Node>> levels) {
        if (root == null)
            return;
        if (levels.size() <= depth) {
            levels.add(new ArrayList<>());
        }
        levels.get(depth).add(root);
        buildLevels(root.left, depth + 1, levels);
        buildLevels(root.right, depth + 1, levels);
    }
}
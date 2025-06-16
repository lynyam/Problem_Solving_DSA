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
        if (root == null) return null;
        inOrder(root, null);
        return (root);
    }

    public void inOrder(Node root, Node right) {
        if (root == null) return;
        root.next = right;
        inOrder(root.left, root.right);
        if (right != null)
            inOrder(root.right, right.left);
        else inOrder(root.right, null);
    }
}
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node flipBinaryTree(Node root, Node leaf) {
        Node curr = leaf;
        Node newParent = null;
        while (curr != root) {
            Node left = curr.left;
            Node right = curr.right;
            Node parent = curr.parent;
            curr.parent = newParent;
            newParent = curr;
            curr.left = parent;
            if (parent != null) {
                if (parent.left.equals(curr))
                    parent.left = null;
                else
                    parent.right = null;
            }
            if (left != null)
                curr.right = left;
            curr = parent;
        }
        curr.parent = newParent;
        return (leaf);
    }
}
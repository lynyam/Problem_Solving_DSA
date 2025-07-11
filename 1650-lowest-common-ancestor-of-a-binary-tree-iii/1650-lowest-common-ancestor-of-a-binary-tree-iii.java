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
    Set<Node> visited = new HashSet<>();

    public Node lowestCommonAncestor(Node p, Node q) {
        if (p == null || visited.contains(p))
            return (null);
        if (p.val == q.val)
            return q;
        visited.add(p);
        Node parent = lowestCommonAncestor(p.parent, q);
        if (parent != null)
            return parent;
        Node left = lowestCommonAncestor(p.left, q);
        if (left != null)
            return p;
        Node right = lowestCommonAncestor(p.right, q);
        if (right != null)
            return p;
        return null;

    }
}
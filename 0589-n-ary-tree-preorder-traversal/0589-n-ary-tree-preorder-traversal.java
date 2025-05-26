/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        List<Node> stack = new ArrayList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node curr = stack.removeLast();
            if (curr != null) result.add(curr.val);
            List<Node> children = curr.children;
            if (children == null) continue;
            for (int i = children.size() - 1; i >= 0; i--) {
                stack.add(children.get(i));
            }
        }
        //dfs(root, result);
        return (result);
    }

    public void dfs(Node root, List<Integer> result) {
        if (root == null) return;
        result.add(root.val);
        for (Node child : root.children) {
            dfs(child, result);
        }
    }

}